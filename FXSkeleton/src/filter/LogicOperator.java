package filter;

public enum LogicOperator {

	AND, OR, ANDNOT;

	public boolean eval(boolean a, boolean b) {
		switch (this) {
		case AND:
			return a && b;
		case OR:
			return a || b;
		case ANDNOT:
			return a && !b;
		}
		return false;
	}

}
