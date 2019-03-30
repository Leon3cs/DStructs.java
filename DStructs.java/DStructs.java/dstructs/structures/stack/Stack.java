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

package dstructs.structures.stack;

import dstructs.structures.list.LinkedList;
import dstructs.structures.list.NodeL;

/**
 *
 * @author Rafael
 */
public class Stack extends LinkedList implements StackServiceI{
    
    public static final int STUDENT_ID = 0;
    public static final int FLAG_TYPE = 1;
    
    private NodeS head;

    private NodeS tail;

    private int length;

    public Stack(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    /**
     * Get the value of length
     *
     * @return the value of length
     */
    @Override
    public int getLength() {
        return length;
    }

    /**
     * Get the value of tail
     *
     * @return the value of tail
     */
    @Override
    public NodeS getTail() {
        return tail;
    }

    /**
     * Set the value of tail
     *
     * @param tail new value of tail
     */
    public void setTail(NodeS tail) {
        this.tail = tail;
    }

    /**
     * Get the value of head
     *
     * @return the value of head
     */
    @Override
    public NodeS getHead() {
        return head;
    }

    /**
     * Set the value of head
     *
     * @param head new value of head
     */
    public void setHead(NodeS head) {
        this.head = head;
    }

    @Override
    public void push(NodeS node) {
         NodeS first;
        
        if(head==null){
            head = node;
            node.setNextNode(tail);
            this.length++;
        }else{
            first = getHead();
            head = node;
            head.setNextNode(first);
            this.length++;
        }
    }

    @Override
    public void pop() {
        if(getLength()>0 && getHead().getNextNode()!=null){
            setHead(getHead().getNextNode());
            this.length--;
        }else{
            throw new IndexOutOfBoundsException(LIST_EMPTY);
        }
    }

    @Override
    public NodeS moveListToPosition(int pos) {
        int count = 0;
        NodeS node = getHead();
        
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
    public NodeS getLast() {
        NodeS pointer = getHead();
        
        while(pointer.getNextNode()!=getTail()){
            pointer = pointer.getNextNode();
        }
        
        return pointer;
    }

    @Override
    public void update(int index, NodeS updated) {
        NodeS selected;
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
    public LinkedList search(String value, int type) {
        int index = 0;
        int[] selected = new int[getLength()];
        NodeS pointer;
        LinkedList result = new LinkedList();
        
        switch(type){
            case Stack.STUDENT_ID:
                pointer = getHead();
                for(int i=0;i<getLength();i++){
                    if(pointer.getStudentId().equals(value)){
                        selected[index] = i;
                        index++;
                    }else{
                        selected[index] = -1;
                        index++;
                    }
                    pointer = pointer.getNextNode();
                }
                break;
            case Stack.FLAG_TYPE:
                pointer = getHead();
                for(int i=0;i<getLength();i++){
                    if(pointer.getFlagType().equals(value)){
                        selected[index] = i;
                        index++;
                    }else{
                        selected[index] = -1;
                        index++;
                    }
                    pointer = pointer.getNextNode();
                }
                break;
        }
        
        for(int i=0;i<selected.length;i++){
            if(selected[i]!=-1){
                result.insertAtEnd(new NodeL(i));
            }
        }
        
        return result;
    }
    
    @Override
    public void print(){
        if(getLength()==0){
            throw new ArrayIndexOutOfBoundsException(LIST_EMPTY);
        }
        if(head.getNextNode()==getTail()){
            System.out.println("List: {{"+getHead().toString()+"}");
        }

        NodeS pointer = getHead();
        
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
    public void reinit(){
        this.head=null;
    }
    
    @Override
    public boolean isEmpty() {
    	return head == null;
    }
}
