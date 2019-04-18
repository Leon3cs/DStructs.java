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
public interface LinkedListServiceI {
    
    /**
     * Adds a node at the head of the list.
     * @param n
     */
    public void insertAtStart(NodeL n);
    /**
     * Adds a node at the tail of the list.
     * @param n
     */
    public void insertAtEnd(NodeL n);
    /**
     * Adds a node at some position in the list using the given index.
     * @param n
     * @param index
     */
    public void insert(NodeL n, int index);
    /**
     * Removes a node of the list from its head.
     */
    public void deleteAtStart();
    /**
     * Removes a node of the list from its tail.
     */
    public void deleteAtEnd();
    /**
     * Removes the node of the list at the given index.
     * @param index
     */
    public void delete(int index);
    /**
     * Retrieves a node from a specific position of the list.
     * @param pos
     * @return A NodeL object
     */
    public NodeL moveListToPosition(int pos);
    /**
     * Retrieves the last node of the list.
     * @return NodeL
     */
    public NodeL getLast();
    /**
     * Changes the value of a node from the list using the given index.
     * @param index
     * @param updated
     */
    public void update(int index, NodeL updated);
    /**
     * Searches for the given value in the list.
     * @param value
     * @return A list of indexes. Each node of this list with a list index which the value was found. If none of the list nodes has that value, it returns an empty list.
     */
    public LinkedList search(int value);
    /**
     * Prints the list in the console.
     */
    public void print();
    /**
     * Reinitializes the list.
     */
    public void reinit();
    /**
     * Checks if the list is empty.
     */
    public boolean isEmpty();
}
