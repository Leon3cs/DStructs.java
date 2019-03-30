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

import dstructs.structures.list.NodeL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Rafael
 */
public class NodeQ extends NodeL{
    
    private Date commitmentDate;

    private String commitmentDescription;

    private NodeQ nextNode;

    public NodeQ(Date commitmentDate, String commitmentDescription, int data) {
        super(data);
        this.commitmentDate = commitmentDate;
        this.commitmentDescription = commitmentDescription;
    }
    
    /**
     * Get the value of nextNode
     *
     * @return the value of nextNode
     */
    @Override
    public NodeQ getNextNode() {
        return nextNode;
    }

    /**
     * Set the value of nextNode
     *
     * @param nextNode new value of nextNode
     */
    public void setNextNode(NodeQ nextNode) {
        this.nextNode = nextNode;
    }

    /**
     * Get the value of commitmentDescription
     *
     * @return the value of commitmentDescription
     */
    public String getCommitmentDescription() {
        return commitmentDescription;
    }

    /**
     * Set the value of commitmentDescription
     *
     * @param commitmentDescription new value of commitmentDescription
     */
    public void setCommitmentDescription(String commitmentDescription) {
        this.commitmentDescription = commitmentDescription;
    }


    /**
     * Get the value of commitmentDate
     *
     * @return the value of commitmentDate
     */
    public Date getCommitmentDate() {
        return commitmentDate;
    }

    /**
     * Set the value of commitmentDate
     *
     * @param commitmentDate new value of commitmentDate
     */
    public void setCommitmentDate(Date commitmentDate) {
        this.commitmentDate = commitmentDate;
    }
    
    @Override
    public String toString(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        return super.getId() + " " + formatter.format(commitmentDate.getTime()) + " " + commitmentDescription;
    }
}
