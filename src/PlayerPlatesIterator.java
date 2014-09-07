import java.util.Iterator;
import java.util.Stack;

public class PlayerPlatesIterator implements iterator {

	private Stack<Shape> stk = null;

	public PlayerPlatesIterator(Stack<Shape> data) {
		stk = new Stack<Shape>();
		stk = data;
	}

	@Override
	public Iterator<Shape> createIterator() {
		// TODO Auto-generated method stub

		return stk.iterator();
	}

}
