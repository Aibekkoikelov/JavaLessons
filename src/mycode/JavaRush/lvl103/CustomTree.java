package mycode.JavaRush.lvl103;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

/*
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root;

    public CustomTree() {
        root =  new Entry<String>("rootElement");
    }

    public String getParent(String s) {
        return s;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String set(int index, String element) throws UnsupportedOperationException {
        return super.set(index, element);
    }

    @Override
    public void add(int index, String element) throws UnsupportedOperationException {
        super.add(index, element);
    }

    @Override
    public String remove(int index) throws UnsupportedOperationException {
        return super.remove(index);
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
//        return super.addAll(index, c);
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) throws UnsupportedOperationException {
//        return super.subList(fromIndex, toIndex);
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) throws UnsupportedOperationException {
        super.removeRange(fromIndex, toIndex);
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren | availableToAddRightChildren;
        }
    }
}
