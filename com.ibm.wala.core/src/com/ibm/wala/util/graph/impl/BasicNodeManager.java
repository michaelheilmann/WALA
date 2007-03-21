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

import java.util.HashSet;
import java.util.Iterator;

import com.ibm.wala.util.collections.HashSetFactory;
import com.ibm.wala.util.graph.NodeManager;

/**
 *
 * Simple implementation of a Node Manager.
 * 
 * @author sfink
 */
public class BasicNodeManager<T> implements NodeManager<T> {

  private HashSet<T> nodes = HashSetFactory.make();

  /* (non-Javadoc)
   * @see com.ibm.wala.util.graph.NodeManager#iterateNodes()
   */
  public Iterator<T> iterator() {
    return nodes.iterator();
  }

  /* (non-Javadoc)
   * @see com.ibm.wala.util.graph.NodeManager#getNumberOfNodes()
   */
  public int getNumberOfNodes() {
    return nodes.size();
  }

  /* (non-Javadoc)
   * @see com.ibm.wala.util.graph.NodeManager#addNode(com.ibm.wala.util.graph.Node)
   */
  public void addNode(T n) {
    nodes.add(n);
  }

  /* (non-Javadoc)
   * @see com.ibm.wala.util.graph.NodeManager#remove(com.ibm.wala.util.graph.Node)
   */
  public void removeNode(T n) {
    nodes.remove(n);
  }

  /* (non-Javadoc)
   * @see com.ibm.wala.util.graph.NodeManager#containsNode(com.ibm.wala.util.graph.Node)
   */
  public boolean containsNode(T N) {
    return nodes.contains(N);
  }

}
