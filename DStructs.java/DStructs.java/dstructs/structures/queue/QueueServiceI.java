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

package dstructs.structures.queue;

import dstructs.structures.list.LinkedList;
import dstructs.structures.list.LinkedListServiceI;

/**
 *
 * @author Rafael
 */
public interface QueueServiceI extends LinkedListServiceI{
    
    /**
     * Adds a node to the queue;
     * @param node
     */
    public void append(NodeQ node);
    /**
     * Removes a node from the queue;
     */
    public void remove();
    @Override
    public NodeQ moveListToPosition(int pos);
    @Override
    public NodeQ getLast();
    /**
     * Changes the node in the specified index for a new given node
     * @param index
     * @param updated
     */
    public void update(int index, NodeQ updated);
    /**
     * Searches for all the occurrences in a specified node attribute type with the specified value.
     * 
     * 0 - for College Registry
     * 1 = for Flag type
     * 
     * @param value
     * @param type
     * @return A list of indexes. Each node of this list with a queue index which the value was found. If none of the queue nodes has that value, it returns an empty list.
     */
    public LinkedList search(String value, int type);
    @Override
    public void print();
    /**
     * Reinitializes the queue.
     */
    @Override
    public void reinit();
    @Override
    public boolean isEmpty();
}
