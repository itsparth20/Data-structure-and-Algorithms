package com.helper.tree;

public class TreeNode<T> {

    private TreeNode left;
    private TreeNode right;
    private T value;

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void setValue(T value) {
        this.value = value;
    }


    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public T getValue() {
        return value;
    }

    public static class Builder<T> {
        private TreeNode left;
        private TreeNode right;
        private T value;

        public Builder left(TreeNode left) {
            this.left = left;
            return this;
        }

        public Builder right(TreeNode right) {
            this.right = right;
            return this;
        }

        public Builder value(T value) {
            this.value = value;
            return this;
        }

        public TreeNode build() {
            return new TreeNode(this);
        }
    }

    public TreeNode(Builder<T> builder) {
        left = builder.left;
        right = builder.right;
        value = builder.value;
    }

    public TreeNode(T value){
        this.value = value;
    }

}
