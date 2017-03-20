/*---------------------------------
 * 作者：白浩然
 * 版本：Cal_Java_1.0
 * 功能：计算表达式的值（String 类型的表达式）
 *-------------------------------*/

class Calculator {
	// -------------------------------------------------类开始-------------------------------------------
	static final int FLAG = 0;
	static final int ADD = 1;
	static final int SUB = 2;
	static final int MUL = 3;
	static final int DIV = 4;
	static final int EXC = 5;
	static final int LBRACKET = 6;
	static final int RBRACKET = 7;
	static final int SIN = 8;
	static final int COS = 9;
	static final int TAN = 10;
	static final int LABS = 11;
	static final int RABS = 12;
	static final int LOG = 13;
	static final int LOW = 14;
	static final int HIGH = 15;
	static final int NEG = 16;
	static final int LN = 19;
	static final int LG = 20;
	static final int SQRT = 21;
	static final int MOD = 22;
	static final int FAC = 23;
	static final double PI = 3.1415926535897932;
	static final double E = 2.7182818284590452;

	private static int miPos = 0; // 当前位置
	private static double metric = 0.0; // 比例因子
	private static double mdbResult = 0.0; // 计算结
	private static String expression = null; // 表达式
	private static double left = 0.0, right = 0.0; // 操作数
	private static Stack_int operator = new Stack_int(); // 运算符栈
	private static Stack_double operand = new Stack_double(); // 操作数栈

	public static double calculate(String aExpression) {
		expression = '#' + aExpression + '#'; // aExpression.replaceAll(" ",
												// "").replaceAll......

		miPos = 0;
		operand.clear();
		operator.clear();
		while (miPos < expression.length()) {
			char x = expression.charAt(miPos);
			if (x >= '0' && x <= '9' || x == '.') {
				mdbResult = changeToNumber();
				operand.push(mdbResult);
			} // if
			switch (x) {
			case 'p':
				operand.push(PI);
				miPos += 2;
				break;
			case 'e':
				operand.push(E);
				miPos++;
				break;
			case ' ':
				miPos++;
				break;
			case '#': {
				if (operator.size() == 0) {
					operator.push(FLAG);
					miPos++;
				} else
					makeOperate();
			}
				break;
			case '+': {

				if (judgePush(operator.getTop(), ADD)) {
					operator.push(ADD);
					miPos++;
				} else
					makeOperate();
			}
				break;
			case '-': {

				if (operator.getBinaryOperatorNum() + 1 <= operand.size())
					if (judgePush(operator.getTop(), SUB)) {
						operator.push(SUB);
						miPos++;
					} else
						makeOperate();
				else if (judgePush(operator.getTop(), NEG)) {
					operator.push(NEG);
					miPos++;
				} else
					makeOperate();
			}
				break;
			case '*': {

				if (judgePush(operator.getTop(), MUL)) {
					operator.push(MUL);
					miPos++;
				} else
					makeOperate();
			}
				break;
			case '/': {

				if (judgePush(operator.getTop(), DIV)) {
					operator.push(DIV);
					miPos++;
				} else
					makeOperate();
			}
				break;
			case '^': {

				if (judgePush(operator.getTop(), EXC)) {
					operator.push(EXC);
					miPos++;
				} else
					makeOperate();
			}
				break;
			case '(': {

				if (judgePush(operator.getTop(), LBRACKET)) {
					operator.push(LBRACKET);
					miPos++;
				} else
					makeOperate();
			}
				break;
			case ')':
				makeOperate();
				break;
			case 's': {

				if (expression.charAt(++miPos) == 'i') {
					if (judgePush(operator.getTop(), SIN)) {
						operator.push(SIN);
						miPos += 2;
					} else
						makeOperate();
				} else {
					if (judgePush(operator.getTop(), SQRT)) {
						operator.push(SQRT);
						miPos += 3;
					} else
						makeOperate();
				}
			}
				break;
			case 'c': {

				if (judgePush(operator.getTop(), COS)) {
					operator.push(COS);
					miPos += 3;
				} else
					makeOperate();
			}
				break;
			case 't': {

				if (judgePush(operator.getTop(), TAN)) {
					operator.push(TAN);
					miPos += 3;
				} else
					makeOperate();
			}
				break;
			case '|': {

				if (operator.getBinaryOperatorNum() + 1 <= operand.size())
					makeOperate();
				else if (judgePush(operator.getTop(), LABS)) {
					operator.push(LABS);
					miPos++;
				} else
					makeOperate();
			}
				break;
			case 'l': {
				char te = expression.charAt(++miPos);
				if (te == 'o') {

					if (judgePush(operator.getTop(), LOG)) {
						operator.push(LOG);
						miPos += 2;
					} else {
						makeOperate();
					}
				} else if (te == 'g') {

					if (judgePush(operator.getTop(), LG)) {
						operator.push(LG);
						miPos++;
					} else
						makeOperate();
				} else {

					if (judgePush(operator.getTop(), LN)) {
						operator.push(LN);
						miPos++;
					} else
						makeOperate();
				}
			}
				break;
			case '_': {

				if (judgePush(operator.getTop(), LOW)) {
					operator.push(LOW);
					miPos++;
				} else
					makeOperate();
			}
				break;
			case '~': {

				if (judgePush(operator.getTop(), HIGH)) {
					operator.push(HIGH);
					miPos++;
				} else
					makeOperate();
			}
				break;
			case '%': {

				if (judgePush(operator.getTop(), MOD)) {
					operator.push(MOD);
					miPos++;
				} else
					makeOperate();
			}
				break;
			case '!': {

				if (judgePush(operator.getTop(), FAC)) {
					operator.push(FAC);
					miPos++;
				} else
					makeOperate();
			}
				break;
			}// switch
		} // while

		return mdbResult;
	}// calculate

	private static boolean judgePush(int aOld, int aNew) {
		switch (aOld) {
		case FLAG: {
			switch (aNew) {
			case FLAG:
				return false;
			default:
				return true;
			}
		}
		case ADD:
		case SUB: {
			switch (aNew) {
			case FLAG:
				return false;
			case ADD:
				return false;
			case SUB:
				return false;
			case MUL:
				return true;
			case DIV:
				return true;
			case EXC:
				return true;
			case LBRACKET:
				return true;
			case RBRACKET:
				return false;
			case SIN:
				return true;
			case COS:
				return true;
			case TAN:
				return true;
			case LABS:
				return true;
			case RABS:
				return false;
			case LOG:
				return true;
			case LOW:
				return true;
			case HIGH:
				return false;
			case NEG:
				return true;
			case LN:
				return true;
			case LG:
				return true;
			case SQRT:
				return true;
			case FAC:
				return true;
			case MOD:
				return true;
			}
		}
			break;
		case MUL:
		case DIV: {
			switch (aNew) {
			case FLAG:
				return false;
			case ADD:
				return false;
			case SUB:
				return false;
			case MUL:
				return false;
			case DIV:
				return false;
			case EXC:
				return true;
			case LBRACKET:
				return true;
			case RBRACKET:
				return false;
			case SIN:
				return true;
			case COS:
				return true;
			case TAN:
				return true;
			case LABS:
				return true;
			case RABS:
				return false;
			case LOG:
				return true;
			case LOW:
				return true;
			case HIGH:
				return false;
			case NEG:
				return true;
			case LN:
				return true;
			case LG:
				return true;
			case SQRT:
				return true;
			case FAC:
				return true;
			case MOD:
				return false;
			}
		}
			break;
		case EXC: {
			switch (aNew) {
			case FLAG:
				return false;
			case ADD:
				return false;
			case SUB:
				return false;
			case MUL:
				return false;
			case DIV:
				return false;
			case EXC:
				return false;
			case LBRACKET:
				return true;
			case RBRACKET:
				return false;
			case SIN:
				return true;
			case COS:
				return true;
			case TAN:
				return true;
			case LABS:
				return true;
			case RABS:
				return false;
			case LOG:
				return true;
			case LOW:
				return true;
			case HIGH:
				return false;
			case NEG:
				return true;
			case LN:
				return true;
			case LG:
				return true;
			case SQRT:
				return true;
			case FAC:
				return true;
			case MOD:
				return false;
			}
		}
			break;
		case LBRACKET: {
			switch (aNew) {
			case FLAG:
				return false;
			case ADD:
				return true;
			case SUB:
				return true;
			case MUL:
				return true;
			case DIV:
				return true;
			case EXC:
				return true;
			case LBRACKET:
				return true;
			case RBRACKET:
				return false;
			case SIN:
				return true;
			case COS:
				return true;
			case TAN:
				return true;
			case LABS:
				return true;
			case RABS:
				return false;
			case LOG:
				return true;
			case LOW:
				return true;
			case HIGH:
				return false;
			case NEG:
				return true;
			case LN:
				return true;
			case LG:
				return true;
			case SQRT:
				return true;
			case FAC:
				return true;
			case MOD:
				return true;
			}
		}
			break;
		case SIN:
		case COS:
		case TAN: {
			switch (aNew) {
			case FLAG:
				return false;
			case ADD:
				return false;
			case SUB:
				return false;
			case MUL:
				return false;
			case DIV:
				return false;
			case EXC:
				return true;
			case LBRACKET:
				return true;
			case RBRACKET:
				return false;
			case SIN:
				return true;
			case COS:
				return true;
			case TAN:
				return true;
			case LABS:
				return true;
			case RABS:
				return false;
			case LOG:
				return true;
			case LOW:
				return true;
			case HIGH:
				return false;
			case NEG:
				return true;
			case LN:
				return true;
			case LG:
				return true;
			case SQRT:
				return true;
			case FAC:
				return true;
			case MOD:
				return false;
			}
		}
			break;
		case LABS: {
			switch (aNew) {
			case FLAG:
				return false;
			case ADD:
				return true;
			case SUB:
				return true;
			case MUL:
				return true;
			case DIV:
				return true;
			case EXC:
				return true;
			case LBRACKET:
				return true;
			case RBRACKET:
				return false;
			case SIN:
				return true;
			case COS:
				return true;
			case TAN:
				return true;
			case LABS:
				return true;
			case RABS:
				return false;
			case LOG:
				return true;
			case LOW:
				return true;
			case HIGH:
				return false;
			case NEG:
				return true;
			case LN:
				return true;
			case LG:
				return true;
			case SQRT:
				return true;
			case FAC:
				return true;
			case MOD:
				return true;
			}
		}
			break;
		case LN:
		case LG:
		case LOG: {
			switch (aNew) {
			case FLAG:
				return false;
			case ADD:
				return false;
			case SUB:
				return false;
			case MUL:
				return false;
			case DIV:
				return false;
			case EXC:
				return true;
			case LBRACKET:
				return true;
			case RBRACKET:
				return false;
			case SIN:
				return true;
			case COS:
				return true;
			case TAN:
				return true;
			case LABS:
				return true;
			case RABS:
				return false;
			case LOG:
				return true;
			case LOW:
				return true;
			case HIGH:
				return false;
			case NEG:
				return true;
			case LN:
				return true;
			case LG:
				return true;
			case SQRT:
				return true;
			case FAC:
				return true;
			case MOD:
				return false;
			}
		}
			break;
		case LOW: {
			switch (aNew) {
			case FLAG:
				return false;
			case ADD:
				return true;
			case SUB:
				return true;
			case MUL:
				return true;
			case DIV:
				return true;
			case EXC:
				return true;
			case LBRACKET:
				return true;
			case RBRACKET:
				return false;
			case SIN:
				return true;
			case COS:
				return true;
			case TAN:
				return true;
			case LABS:
				return true;
			case RABS:
				return false;
			case LOG:
				return true;
			case LOW:
				return true;
			case HIGH:
				return true;
			case NEG:
				return true;
			case LN:
				return true;
			case LG:
				return true;
			case SQRT:
				return true;
			case FAC:
				return true;
			case MOD:
				return true;
			}
		}
			break;
		case HIGH: {
			switch (aNew) {
			case FLAG:
				return false;
			case ADD:
				return false;
			case SUB:
				return false;
			case MUL:
				return false;
			case DIV:
				return false;
			case EXC:
				return true;
			case LBRACKET:
				return true;
			case RBRACKET:
				return false;
			case SIN:
				return true;
			case COS:
				return true;
			case TAN:
				return true;
			case LABS:
				return true;
			case RABS:
				return false;
			case LOG:
				return true;
			case LOW:
				return true;
			case HIGH:
				return false;
			case NEG:
				return true;
			case LN:
				return true;
			case LG:
				return true;
			case SQRT:
				return true;
			case FAC:
				return true;
			case MOD:
				return false;
			}
		}
			break;
		case NEG:
		case SQRT: {
			switch (aNew) {
			case FLAG:
				return false;
			case ADD:
				return false;
			case SUB:
				return false;
			case MUL:
				return false;
			case DIV:
				return false;
			case EXC:
				return true;
			case LBRACKET:
				return true;
			case RBRACKET:
				return false;
			case SIN:
				return true;
			case COS:
				return true;
			case TAN:
				return true;
			case LABS:
				return true;
			case RABS:
				return false;
			case LOG:
				return true;
			case LOW:
				return true;
			case HIGH:
				return false;
			case NEG:
				return true;
			case LN:
				return true;
			case LG:
				return true;
			case SQRT:
				return true;
			case FAC:
				return true;
			case MOD:
				return false;
			}
		}
			break;
		case FAC: {
			switch (aNew) {
			case FLAG:
				return false;
			case ADD:
				return false;
			case SUB:
				return false;
			case MUL:
				return false;
			case DIV:
				return false;
			case EXC:
				return false;
			case LBRACKET:
				return true;
			case RBRACKET:
				return false;
			case SIN:
				return true;
			case COS:
				return true;
			case TAN:
				return true;
			case LABS:
				return true;
			case RABS:
				return false;
			case LOG:
				return true;
			case LOW:
				return true;
			case HIGH:
				return false;
			case NEG:
				return true;
			case LN:
				return true;
			case LG:
				return true;
			case SQRT:
				return true;
			case FAC:
				return false;
			case MOD:
				return false;
			}
		}
			break;
		case MOD: {
			switch (aNew) {
			case FLAG:
				return false;
			case ADD:
				return false;
			case SUB:
				return false;
			case MUL:
				return false;
			case DIV:
				return false;
			case EXC:
				return true;
			case LBRACKET:
				return true;
			case RBRACKET:
				return false;
			case SIN:
				return true;
			case COS:
				return true;
			case TAN:
				return true;
			case LABS:
				return true;
			case RABS:
				return false;
			case LOG:
				return true;
			case LOW:
				return true;
			case HIGH:
				return false;
			case NEG:
				return true;
			case LN:
				return true;
			case LG:
				return true;
			case SQRT:
				return true;
			case FAC:
				return true;
			case MOD:
				return false;
			}
		}
			break;
		}

		return true;

	}// judgePush

	private static void makeOperate() {
		int flag = operator.pop();

		switch (flag) {
		case FLAG: {
			while (operand.size() > 0) {
				mdbResult = operand.pop();
			}
			miPos++;
		}
			break;
		case ADD: {
			right = operand.pop();
			left = operand.pop();
			operand.push(left + right);
		}
			break;
		case SUB: {
			right = operand.pop();
			left = operand.pop();
			operand.push(left - right);
		}
			break;
		case MUL: {
			right = operand.pop();
			left = operand.pop();
			operand.push(left * right);
		}
			break;
		case DIV: {
			right = operand.pop();
			left = operand.pop();
			operand.push(left / right);
		}
			break;
		case EXC: {
			right = operand.pop();
			left = operand.pop();
			operand.push(Math.pow(left, right));
		}
			break;
		case LBRACKET:
			miPos++;
			break;
		case SIN: {
			left = operand.pop();
			operand.push(Math.sin(left));
		}
			break;
		case COS: {
			left = operand.pop();
			operand.push(Math.cos(left));
		}
			break;
		case TAN: {
			left = operand.pop();
			operand.push(Math.tan(left));
		}
			break;
		case LABS: {
			left = operand.pop();
			operand.push(Math.abs(left));
			miPos++;
		}
			break;
		case LOG:
			break;
		case LOW:
			break;
		case HIGH: {
			left = operand.pop();
			right = operand.pop();
			operand.push(Math.log(left) / Math.log(right));
			operator.pop();
			operator.pop();
		}
			break;
		case NEG: {
			left = operand.pop();
			operand.push(0 - left);
		}
			break;
		case LN: {
			left = operand.pop();
			operand.push(Math.log(left));
		}
			break;
		case LG: {
			left = operand.pop();
			operand.push(Math.log10(left));
		}
			break;
		case SQRT: {
			left = operand.pop();
			operand.push(Math.sqrt(left));
		}
			break;
		case MOD: {
			right = operand.pop();
			left = operand.pop();
			operand.push((int) (left) % (int) (right));
		}
			break;
		case FAC: {
			left = operand.pop();
			operand.push(fac((int) (left)));
		}
			break;
		}
	}// makeOperate

	private static int fac(int n) {
		if (n <= 1)
			return 1;

		for (int i = n - 1; i > 1; i--) {
			n = n * i;
		} // for

		return n;
	}// fac

	private static double changeToNumber() {
		left = 0.0;
		right = 0.0;
		metric = 1.0;

		while (expression.charAt(miPos) >= '0' && expression.charAt(miPos) <= '9')
			left = left * 10 + (double) (expression.charAt(miPos++) - '0');

		if (expression.charAt(miPos) == '.') {
			miPos++;
			while (expression.charAt(miPos) >= '0' && expression.charAt(miPos) <= '9') {
				metric /= 10;
				right = right + metric * (double) (expression.charAt(miPos++) - '0');
			}
		}

		double result = left + right;

		left = 0.0;
		right = 0.0;
		metric = 1.0;
		boolean isFu = false;
		if (expression.charAt(miPos) == 'E') {
			miPos++;
			if (expression.charAt(miPos) == '-') {
				isFu = true;
				miPos++;
			} // if

			while (expression.charAt(miPos) >= '0' && expression.charAt(miPos) <= '9')
				left = left * 10 + (double) (expression.charAt(miPos++) - '0');

			if (expression.charAt(miPos) == '.') {
				miPos++;
				while (expression.charAt(miPos) >= '0' && expression.charAt(miPos) <= '9') {
					metric /= 10;
					right = right + metric * (double) (expression.charAt(miPos++) - '0');
				} // while
			} // if

		} // if

		if (isFu) {
			return result * Math.pow(10, 0 - left - right);
		} // if

		return result * Math.pow(10, left + right);
	}// changeToNumber
}// Calculator

class Stack_int {
	private static final int maxSize = 4097;

	private int length;
	private int[] dataBase;

	public Stack_int() {
		dataBase = new int[maxSize];
		length = 0;

	}// con_Stack_int

	public void push(int aData) {
		dataBase[length++] = aData;

	}// push

	public int pop() {
		return dataBase[--length];

	}// pop

	public int getBinaryOperatorNum() {
		int num = 0;

		for (int i = 0; i < length; i++) {
			if (dataBase[i] == 1 || dataBase[i] == 2 || dataBase[i] == 3 || dataBase[i] == 4 || dataBase[i] == 5
					|| dataBase[i] == 15) {
				num++;

			} // if

		} // for

		return num;

	}// getBinaryOperatorNum

	public int size() {
		return length;

	}// size

	public int getTop() {
		return dataBase[length - 1];

	}// getTop

	public void clear() {
		length = 0;
	}// clear

}// class_Stack_int

class Stack_double {
	private static final int maxSize = 4097;

	private int length;
	private double[] dataBase;

	public Stack_double() {
		dataBase = new double[maxSize];
		length = 0;

	}// con_Stack_double

	public void push(double aData) {
		dataBase[length++] = aData;

	}// push

	public double pop() {
		return dataBase[--length];

	}// pop

	public int size() {
		return length;

	}// size

	public void clear() {
		length = 0;
	}// clear

}// class_Stack_double