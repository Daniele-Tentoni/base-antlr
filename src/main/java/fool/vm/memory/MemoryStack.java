package fool.vm.memory;

import java.util.Stack;

/**
 * Represent an abstraction from the simple memory stack.
 */
public class MemoryStack {
  private final int maxSize;
  private final Stack<Integer> memory;
  private int stackPointer;

  /**
   * Initialize the memory stack.
   *
   * @param maxSize maximum size of the stack. Over that, any increase
   *                operation will result in an error like Stack Overflow
   *                Exception.
   */
  public MemoryStack(int maxSize) {
    this.maxSize = maxSize;
    stackPointer = 0;
    memory = new Stack<>();
  }

  /**
   * Return a defined element in the memory.
   *
   * @param index index of the resource.
   * @return required element.
   */
  public int get(int index) {
    if (index >= memory.size() || index < 0) {
      throw new IndexOutOfBoundsException();
    }
    return memory.get(index);
  }

  /**
   * Set a defined element in the memory.
   *
   * @param index index of the resource.
   * @param value given value.
   * @return -1 if operation fail, given value otherwise.
   */
  public int set(int index, Integer value) {
    if (index >= memory.size() || index < 0) {
      throw new IndexOutOfBoundsException("Index out of range of memory");
    }
    return memory.set(index, value);
  }

  /**
   * Retrieve the last element from memory and return it.
   *
   * @return value of last element.
   */
  public int pop() {
    if (memory.size() == 0) {
      throw new StackOverflowError(
          "Reached bottom memory limit in the memory stack.");
    }
    return memory.pop();
  }

  /**
   * Insert a new element on top of memory.
   *
   * @param v value to insert.
   */
  public void push(int v) {
    if (memory.size() == maxSize) {
      throw new StackOverflowError(
          "Reached upper memory limit in the memory stack.");
    }
    memory.push(v);
  }
}
