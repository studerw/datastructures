package com.studerw.datastructures.ch8;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Iterator; // Import Iterator

/**
 * Defines the contract for a generic Tree Abstract Data Type (ADT).
 * This interface supports a general tree structure, where nodes can have
 * any number of children (not limited to binary trees).
 * It now extends Iterable, allowing for enhanced for-loop usage.
 *
 * @param <E> The type of elements stored in the tree.
 */
public interface Tree<E> extends Iterable<E> { // Added extends Iterable<E>

    /**
     * Enum to define different tree traversal orders.
     */
    enum TraversalOrder {
        PRE_ORDER,      // Root, Left, Right (or Root, Children)
        POST_ORDER,     // Left, Right, Root (or Children, Root)
        LEVEL_ORDER     // Level by level
    }

    /**
     * Adds a new node with {@code childData} as a child of the node
     * containing {@code parentData}. If {@code parentData} is null,
     * {@code childData} becomes the root (if the tree is empty).
     *
     * @param parentData The data of the parent node. Can be null if adding the root.
     * @param childData  The data of the new child node to be added. Must not be null.
     * @return true if the node was successfully added, false otherwise (e.g., parent not found, child already exists).
     * @throws IllegalArgumentException if childData is null, or if parentData is null and tree is not empty.
     */
    boolean add(E parentData, E childData);

    /**
     * Removes the node containing {@code data} and its entire subtree.
     * If the root is removed, the tree becomes empty.
     *
     * @param data The data of the node to be removed.
     * @return true if the node was successfully removed, false otherwise (e.g., node not found).
     * @throws IllegalArgumentException if data is null.
     */
    boolean remove(E data);

    /**
     * Checks if the tree contains a node with the specified data.
     *
     * @param data The data to search for.
     * @return true if the tree contains the data, false otherwise.
     * @throws IllegalArgumentException if data is null.
     */
    boolean contains(E data);

    /**
     * Checks if the tree is empty.
     *
     * @return true if the tree contains no nodes, false otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the total number of nodes in the tree.
     *
     * @return The number of nodes.
     */
    int size();

    /**
     * Clears all nodes from the tree, making it empty.
     */
    void clear();

    /**
     * Returns the data of the root node of the tree.
     *
     * @return An {@link Optional} containing the root's data if the tree is not empty,
     * otherwise an empty {@link Optional}.
     */
    Optional<E> getRoot();

    /**
     * Returns the data of the parent node of the node containing {@code data}.
     *
     * @param data The data of the node whose parent is to be found.
     * @return An {@link Optional} containing the parent's data if found and exists,
     * otherwise an empty {@link Optional}.
     * @throws IllegalArgumentException if data is null.
     */
    Optional<E> getParent(E data);

    /**
     * Returns a list of data for all direct children of the node containing {@code data}.
     *
     * @param data The data of the node whose children are to be retrieved.
     * @return A {@link List} of child data. Returns an empty list if the node is not found
     * or has no children.
     * @throws IllegalArgumentException if data is null.
     */
    List<E> getChildren(E data);

    /**
     * Checks if the node containing {@code data} is a leaf node (i.e., has no children).
     *
     * @param data The data of the node to check.
     * @return true if the node is a leaf, false otherwise (e.g., node not found or has children).
     * @throws IllegalArgumentException if data is null.
     */
    boolean isLeaf(E data);

    /**
     * Checks if the node containing {@code data} is the root node of the tree.
     *
     * @param data The data of the node to check.
     * @return true if the node is the root, false otherwise (e.g., node not found or not the root).
     * @throws IllegalArgumentException if data is null.
     */
    boolean isRoot(E data);

    /**
     * Returns the height of the tree. The height of an empty tree is -1.
     * The height of a single-node tree (root only) is 0.
     *
     * @return The height of the tree.
     */
    default int getHeight() {
        if (getRoot().isPresent()) {
            return getNodeHeight(getRoot().get());
        }
        return -1;
    };

    /**
     * Returns the height from the point of view of the node. The height of an empty tree is -1.
     * The height of a single-node tree (root only) is 0.
     *
     * @return The height from the passed node.
     */
    default int getNodeHeight(E data) {
        Objects.requireNonNull(data);
        int height = 0;
        for (E childData : getChildren(data)) {
            height = Math.max(height, 1 + getNodeHeight(childData));
        }
        return height;
    };

    /**
     * Returns the depth of the node containing {@code data}. The depth of the root is 0.
     *
     * @param data The data of the node whose depth is to be found.
     * @return The depth of the node, or -1 if the node is not found.
     * @throws IllegalArgumentException if data is null.
     */
    default int getDepth(E data) {
        Objects.requireNonNull(data);
        if (isRoot(data)) {
            return 0;
        }
        return 1 + getDepth(getParent(data).get());

    };

    /**
     * Performs a traversal of the tree in the specified order and returns a list
     * of all elements in that order.
     *
     * @param order The {@link TraversalOrder} to use for traversal.
     * @return A {@link List} of elements in the specified traversal order.
     * Returns an empty list if the tree is empty.
     * @throws IllegalArgumentException if order is null.
     */
    List<E> traverse(TraversalOrder order);

    /**
     * Returns an iterator over elements of type {@code E}.
     * The iteration order is typically defined by the implementation (e.g., level-order or pre-order).
     *
     * @return an {@link Iterator} over the elements in this tree.
     */
    @Override
    Iterator<E> iterator();
}
