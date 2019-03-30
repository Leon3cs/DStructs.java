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

import dstructs.structures.list.NodeL;

/**
 *
 * @author Rafael
 */
public class NodeS extends NodeL{
    
    public static final String FLAG_LOST = "Lost my access card";
    public static final String FLAG_FORGOTTEN = "Forgot my access card";
    public static final String FLAG_NEW_STUDENT = "Don't have an access card yet";
    public static final String FLAG_VISITOR = "Visitor";
    public static final String FLAG_VIP = "VIP";
    
    private String studentId;

    private String flagType;

    private NodeS nextNode;

    public NodeS(String studentId, String flagType, int data) {
        super(data);
        this.studentId = studentId;
        this.flagType = flagType;
    }
    /**
     * Get the value of nextNode
     *
     * @return the value of nextNode
     */
    @Override
    public NodeS getNextNode() {
        return nextNode;
    }

    /**
     * Set the value of nextNode
     *
     * @param nextNode new value of nextNode
     */
    public void setNextNode(NodeS nextNode) {
        this.nextNode = nextNode;
    }

    /**
     * Get the value of flagType
     *
     * @return the value of flagType
     */
    public String getFlagType() {
        return flagType;
    }

    /**
     * Set the value of flagType
     *
     * @param flagType new value of flagType
     */
    public void setFlagType(String flagType) {
        this.flagType = flagType;
    }

    /**
     * Get the value of studentId
     *
     * @return the value of studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Set the value of studentId
     *
     * @param studentId new value of studentId
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return super.getId() + " " + studentId + " " + flagType;
    }
}
