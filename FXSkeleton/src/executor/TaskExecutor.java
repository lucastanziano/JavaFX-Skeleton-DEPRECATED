package executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import ui.dialogs.AlertDialog;
import ui.dialogs.IDialog;

public class TaskExecutor<T> {

	private TaskExecutor() {

	}

	public static <T> T runTaskWithBlockingDialog(IDialog dialog, Task<T> task)
			throws Exception {

		task.stateProperty().addListener(
				(observableValue, oldState, newState) -> {
					if (newState == Worker.State.SUCCEEDED
							|| newState == Worker.State.FAILED
							|| newState == Worker.State.CANCELLED) {
						dialog.close();
					}
				});
		new Thread(task).start();
		dialog.showAndWait();

		if (task.getException() != null) {
			throw new Exception(task.getException());
		}
		return task.getValue();
	}




	public static <T> List<Task<T>> runTaskListWithBlockingDialog(
			IDialog dialog, List<Task<T>> taskList) throws InterruptedException {

		Runnable taskExecution = new Runnable() {

			@Override
			public void run() {
				int poolSize = taskList.size();
				int queueSize = taskList.size();
				long keepAliveTime = 60;
				NotifyingBlockingThreadPoolExecutor executor = new NotifyingBlockingThreadPoolExecutor(
						poolSize, queueSize, keepAliveTime, TimeUnit.MINUTES);
				List<Future<Task<T>>> results = new ArrayList<Future<Task<T>>>();
				for (Task<T> task : taskList) {
					results.add((Future<Task<T>>) executor.submit(task, task));
				}

				if (executor.getActiveCount() > 0) {
					try {
						executor.await();
						Platform.runLater(() -> {
							StringBuilder sb = new StringBuilder();
							for (Future<Task<T>> result : results) {
								try {
									sb.append(result.get().get() + "\n");
								} catch (Exception e) {

									AlertDialog
											.createError()
											.setStackTraceDetails(e)
											.setHeaderText(
													"An exception occurred during work ticket creation.")
											.showAndWait();
								}
							}
							dialog.close();
							String result = sb.toString();
							if (result.length() > 0) {
								AlertDialog
										.createInfo()
										.setHeaderText(
												"Following tasks are completed")
										.setContentText(result).showAndWait();
							}
						});
					} catch (InterruptedException e) {
						Platform.runLater(() -> {
							dialog.close();
							AlertDialog
									.createError()
									.setStackTraceDetails(e)
									.setHeaderText(
											"Work ticket creation was interrupted.")
									.showAndWait();
						});
					}
				}
				executor.shutdown();
				Platform.runLater(() -> {
					dialog.close();
				});
			}

		};

		new Thread(taskExecution).start();
		dialog.showAndWait();

		return taskList;
	}

}
