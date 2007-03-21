/*******************************************************************************
 * Copyright (c) 2002 - 2006 IBM Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.wala.util.graph.impl;

import java.util.Iterator;

import com.ibm.wala.util.debug.Assertions;
import com.ibm.wala.util.graph.NumberedNodeManager;
import com.ibm.wala.util.intset.IntSet;
import com.ibm.wala.util.intset.MutableMapping;

/**
 * 
 * An object which manages node numbers via a mapping.
 * 
 * @author sfink
 */
public class SlowNumberedNodeManager<T> implements NumberedNodeManager<T> {

  /**
   * A bijection between integer <-> node
   */
  private MutableMapping<T> map = new MutableMapping<T>();


  public int getNumber(Object T) {
    return map.getMappedIndex(T);
  }


  public T getNode(int number)  {
    T result = (T) map.getMappedObject(number);
    return result;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.ibm.wala.util.graph.NumberedGraph#getMaxNumber()
   */
  public int getMaxNumber() {
    return map.getMappingSize() - 1;
  }


  public Iterator<T> iterator() {
    return map.iterator();
  }


  public int getNumberOfNodes() {
    return map.getMappingSize();
  }

  /**
   * Method addNode.
   * 
   * @param n
   */
  public void addNode(T n) {
    if (Assertions.verifyAssertions) {
      Assertions._assert(n != null);
    }
    map.add(n);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.ibm.wala.util.graph.NodeManager#remove(com.ibm.wala.util.graph.Node)
   */
  public void removeNode(T n) {
    map.deleteMappedObject(n);
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  public String toString() {
    StringBuffer result = new StringBuffer("Nodes:\n");
    for (int i = 0; i <= getMaxNumber(); i++) {
      result.append(i).append("  ");
      result.append(map.getMappedObject(i));
      result.append("\n");
    }
    return result.toString();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.ibm.wala.util.graph.NodeManager#containsNode(com.ibm.wala.util.graph.Node)
   */
  public boolean containsNode(T N) {
    return getNumber(N) != -1;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.ibm.wala.util.graph.NumberedNodeManager#iterateNodes(com.ibm.wala.util.intset.IntSet)
   */
  public Iterator<T> iterateNodes(IntSet s) {
    return new NumberedNodeIterator<T>(s, this);
  }

}
