
# 栈 (Stack)

## 一、概念

在 Java 中，栈（Stack）是一种**后进先出（LIFO, Last In First Out）**的数据结构，用于存储元素。

**核心特点：**
- 只有栈顶的元素是可见的和可访问的
- 其他元素都被隐藏起来，直到栈顶的元素被移除或弹出
- Java 中的 `java.util.Stack` 类实现了这种栈的数据结构
- 是线程安全的，继承自 Vector 类

### 基本术语

| 操作 | 说明 |
| :--- | :--- |
| **压栈 (Push)** | 栈的插入操作，入数据在**栈顶** |
| **出栈 (Pop)** | 栈的删除操作，出数据在**栈顶** |

## 二、基本操作

| 方法 | 功能 |
| :--- | :--- |
| `Stack()` | 构造一个空的栈 |
| `E push(E e)` | 将 e 入栈，并返回 e |
| `E pop()` | 将栈顶元素出栈并返回 |
| `E peek()` | 获取栈顶元素（不弹出）--为空时抛出异常 `EmptyStackException` |
| `int size()` | 获取栈中有效元素个数 |
| `boolean empty()` | 检测栈是否为空 |

## 三、代码示例

```java
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        
        // 压栈操作
        stack.push("Java");
        stack.push("Python");
        stack.push("C++");
        
        // 弹栈操作
        String topLanguage = stack.pop();
        System.out.println("弹出栈顶元素：" + topLanguage);
        
        // 查看栈顶元素
        String currentTop = stack.peek();
        System.out.println("当前栈顶元素：" + currentTop);
        
        // 判空操作
        if (stack.isEmpty()) {
            System.out.println("栈为空");
        } else {
            System.out.println("栈不为空");
        }
    }
}
```

## 四、应用场景

栈在 Java 中常用于处理需要**后进先出**顺序的场景：

1. **表达式求值**：如中缀表达式转后缀表达式（逆波兰表达式）
2. **逆序输出**：将输入内容逆序输出
3. **括号匹配**：检查表达式中的括号是否正确匹配
4. **函数调用栈**：Java 虚拟机（JVM）使用栈来管理方法调用
5. **撤销操作**：如文本编辑器的撤销功能

## 五、注意事项

1. `java.util.Stack` 是**线程安全**的，但性能相对较低
2. 如果不需要线程安全，推荐使用 `Deque` 接口（如 `ArrayDeque`）作为栈的实现
3. 调用 `pop()` 或 `peek()` 时，如果栈为空，会抛出 `EmptyStackException`

---

# 队列 (Queue)

## 一、概念

在 Java 中，队列（Queue）是一种**先进先出（FIFO, First In First Out）**的数据结构，用于存储元素。

**核心特点：**
- 只允许在一端进行插入数据操作，在另一端进行删除数据操作的特殊线性表
- Java 中的 `java.util.Queue` 是一个接口，有多种实现类
- 常用实现：`LinkedList`、`ArrayDeque` 和 `PriorityQueue`

### 基本术语

| 操作 | 说明 |
| :--- | :--- |
| **队头（Head/Front）** | 进行删除操作的一端 |
| **队尾（Tail/Rear）** | 进行插入操作的一端 |
| **入队列（Enqueue）** | 在队尾插入元素 |
| **出队列（Dequeue）** | 在队头删除元素 |

## 二、基本操作

| 方法 | 功能 |
| :--- | :--- |
| `boolean offer(E e)` | 入队列，将元素添加到队尾 |
| `E poll()` | 出队列，删除并返回队头元素 |
| `E peek()` | 获取队头元素（不删除） |
| `int size()` | 获取队列中有效元素个数 |
| `boolean isEmpty()` | 检测队列是否为空 |

**注意**：`Queue` 是个接口，在实例化时必须实例化实现类的对象，如 `LinkedList`。

## 三、代码示例

```java
import java.util.Queue;
import java.util.LinkedList;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5); // 从队尾入队列
        
        System.out.println(q.size());      // 输出：5
        System.out.println(q.peek());      // 获取队头元素，输出：1
        
        q.poll();                          // 从队头出队列
        System.out.println(q.poll());      // 从队头出队列并返回，输出：2
        
        if (q.isEmpty()) {
            System.out.println("队列空");
        } else {
            System.out.println(q.size());  // 输出：3
        }
    }
}
```

## 四、常见实现类

| 实现类 | 特点 |
| :--- | :--- |
| `LinkedList` | 基于链表实现，支持队列和双端队列操作 |
| `ArrayDeque` | 基于数组实现，性能优于 `LinkedList`，支持双端队列 |
| `PriorityQueue` | 优先队列，元素按优先级顺序排列 |

## 五、应用场景

队列在 Java 中常用于处理需要**先进先出**顺序的场景：

1. **任务调度**：如线程池中的任务队列
2. **消息传递**：如消息队列系统
3. **广度优先搜索（BFS）**：图遍历算法中使用队列
4. **缓冲处理**：如生产者-消费者模式
5. **打印任务队列**：打印机的任务排队

## 六、注意事项

1. `Queue` 是接口，不能直接实例化
2. `poll()` 和 `peek()` 在队列为空时返回 `null`，不会抛出异常
3. 如果需要双端操作（两端都可以入队和出队），可以使用 `Deque` 接口
