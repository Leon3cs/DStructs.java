/*
The MIT License

Copyright 2019 Rafael.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/

package dstructs.structures.list;

/**
 *
 * @author Rafael
 */
public class LinkedList implements LinkedListServiceI{
    
    public static final String ILLEGAL_INDEX = "ERROR: index invalid, please try again.";
    public static final String LIST_EMPTY = "ERROR: list empty or uninitialized.";
    
    private NodeL head;

    private NodeL tail;

    private int length;

    public LinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    /**
     * Get the value of length
     *
     * @return the value of length
     */
    public int getLength() {
        return length;
    }

    /**
     * Get the value of tail
     *
     * @return the value of tail
     */
    public NodeL getTail() {
        return tail;
    }

    /**
     * Set the value of tail
     *
     * @param tail new value of tail
     */
    public void setTail(NodeL tail) {
        this.tail = tail;
    }

    /**
     * Get the value of head
     *
     * @return the value of head
     */
    public NodeL getHead() {
        return head;
    }

    /**
     * Set the value of head
     *
     * @param head new value of head
     */
    public void setHead(NodeL head) {
        this.head = head;
    }

    @Override
    public void insertAtStart(NodeL n){
        NodeL first;
        
        if(head==null){
            head = n;
            n.setNextNode(tail);
            this.length++;
        }else{
            first = getHead();
            head = n;
            head.setNextNode(first);
            this.length++;
        }
    }
    
    @Override
    public void insertAtEnd(NodeL n){
        if(head==null){
            head = n;
            n.setNextNode(tail);
            this.length++;
        }else{
            NodeL last = getLast();
            
            last.setNextNode(n);
            n.setNextNode(tail);
            this.length++;
        }
    }
    
    @Override
    public void insert(NodeL n, int index){
        NodeL selected;
        NodeL cache;
        
        if(index==0){
            insertAtStart(n);
        }else if(index==getLength()){
            insertAtEnd(n);
        }else if(index>0 && index<=getLength()-1){
            selected = moveListToPosition(index-1);
            cache = selected.getNextNode();
            selected.setNextNode(n);
            n.setNextNode(cache);
            this.length++;
        }else{
            throw new ArrayIndexOutOfBoundsException(ILLEGAL_INDEX);
        }
    }
    
    @Override
    public void deleteAtStart(){
        if(getLength()>0 && getHead().getNextNode()!=null){
            setHead(getHead().getNextNode());
            this.length--;
        }else{
            throw new IndexOutOfBoundsException(LIST_EMPTY);
        }
    }
    
    @Override
    public void deleteAtEnd(){
        if(getLength()>0 && getLast()!=null){
            setTail(getLast());
            this.length--;
        }else{
            throw new IndexOutOfBoundsException(LIST_EMPTY);
        }
    }
    
    @Override
    public void delete(int index){
        NodeL pointer = getHead();
        if(index==0){
            deleteAtStart();
        }else if(index==getLength()-1){
            deleteAtEnd();
        }else if(index>0 && index<getLength()-1){
            for(int i=0;i<index-1&&pointer.getNextNode()!=null;i++){
                pointer = pointer.getNextNode();
            }
            pointer.setNextNode(pointer.getNextNode().getNextNode());
            this.length--;
        }else{
            throw new ArrayIndexOutOfBoundsException(ILLEGAL_INDEX);
        }
    }
    
    @Override
    public void update(int index, NodeL updated){
        NodeL selected;
        if(index==0){
            head.setId(updated.getId());
        }else if(index==getLength()-1){
            selected = getLast();
            selected.setId(updated.getId());
        }else if(index>0 && index<getLength()-1){
            selected = moveListToPosition(index);
            selected.setId(updated.getId());
        }else {
            throw new ArrayIndexOutOfBoundsException(ILLEGAL_INDEX);
        }
    }
    
    @Override
    public void print(){
        if(getLength()==0){
            throw new ArrayIndexOutOfBoundsException(LIST_EMPTY);
        }
        if(head.getNextNode()==getTail()){
            System.out.println("List: {{"+getHead().toString()+"}");
        }

        NodeL pointer = getHead();
        
        if(getLength()>1){
            System.out.print("List: {");
            while(pointer.getNextNode()!=getTail()){
                System.out.print('{'+pointer.toString()+"}, ");
                pointer = pointer.getNextNode();
                if(pointer.getNextNode()==getTail()){
                    System.out.print('{'+pointer.toString()+"}} ");
                }
            }
            System.out.println("");
        }
    }
    
    @Override
    public NodeL getLast(){
        NodeL pointer = getHead();
        
        while(pointer.getNextNode()!=getTail()){
            pointer = pointer.getNextNode();
        }
        
        return pointer;
    }
    
    @Override
    public NodeL moveListToPosition(int pos){
        int count = 0;
        NodeL node = getHead();
        
        if(pos==0){
            return getHead();
        }else if(pos==getLength()-1){
            return getLast();
        }else if(pos>0 && pos<getLength()){
            while(count!=pos){
                if(node.getNextNode()!=getTail()){
                    node = node.getNextNode();
                    count++;
                }
            }
        }else{
            throw new ArrayIndexOutOfBoundsException(ILLEGAL_INDEX);
        }
        
        return node;
    }
    
    @Override
    public LinkedList search(int value){
        int index = 0;
        int[] selected = new int[getLength()];
        NodeL pointer = this.getHead();
        LinkedList result = new LinkedList();
        
        for(int i=0;i<getLength();i++){
            if(pointer.getId()==value){
                selected[index] = i;
                index++;
            }else{
                selected[index] = -1;
                index++;
            }
            pointer = pointer.getNextNode();
        }
        
        for(int i=0;i<selected.length;i++){
            if(selected[i]!=-1){
                result.insertAtEnd(new NodeL(selected[i]));
            }
        }
        
        return result;
    }
    
    @Override
    public void reinit(){
        this.head=null;
    }

	@Override
	public boolean isEmpty() {
		return head == null;
	}
}
