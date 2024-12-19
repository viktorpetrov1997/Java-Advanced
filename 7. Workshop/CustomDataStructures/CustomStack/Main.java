package Workshop.CustomDataStructures.CustomStack;

public class Main
{
    public static void main(String[] args)
    {
        CustomStack customStack = new CustomStack();

        customStack.push(1);
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);
        customStack.push(5);
        customStack.push(6);
        customStack.push(7);
        customStack.push(8);
        customStack.push(9);
        customStack.push(10);

        System.out.print("Popped elements: ");
        System.out.print(customStack.pop() + " ");
        System.out.print(customStack.pop());

        System.out.println();

        System.out.print("Peek element: ");
        System.out.print(customStack.peek());

        System.out.println();

        System.out.print("Print elements: ");
        customStack.forEach(element -> System.out.print(element + " "));
    }
}
