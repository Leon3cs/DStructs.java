import dstructs.structures.list.LinkedList;
import dstructs.structures.list.NodeL;

public class testemain {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.insertAtEnd(new NodeL(1));
		list.insertAtEnd(new NodeL(2));
		list.insertAtEnd(new NodeL(3));
		list.insertAtEnd(new NodeL(4));
		
		for(int i=0;i<list.getLength();i++) {
			System.out.println(list.moveListToPosition(i).getId());
		}

	}

}
