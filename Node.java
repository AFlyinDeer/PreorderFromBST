public class Node {
    int data;
    Node left, right;
    Node(int data)
    {
        this.data = data;
        this.left = this.right = null;
    }
}

class CreateBSTFromPreorder {
    private static Node node;
    
    // This will create the BST
    public static Node createNode(Node node, int data){
        if (node == null)
            node = new Node(data);
        
        if (node.data > data)
            node.left = createNode(node.left, data);
        if (node.data < data)
            node.right = createNode(node.right, data);
        
        return node;
    }
    
    // A wrapper function of createNode
    public static void create(int data){
        node = createNode(node, data);
    }
    
    // A function to print BST in inorder
    public static void inorderRec(Node root){
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.data);
            inorderRec(root.right);
        }
    }

    private static int[] GetUserInput(){
        // create int array
        int[] numbers = new int[15];

        // get input from user
        System.out.print("Enter 15 integers separated by commas (ex: 1,2,3...)\n");
        String input = System.console().readLine();

        // Split input string into string array
        String[] stringNumbers = input.split(",");

        // Convert string array to int array
        for (int i = 0; i < stringNumbers.length; i++) {
            try {
                // try to parse individudal string to int
                int number = Integer.parseInt(stringNumbers[i]);
                // add int to int array
                numbers[i] = number;
            }
            catch(NumberFormatException e) {
                System.out.print("\nError: Non integer detected\n");
                System.out.print("Please restart the program and only enter integers\n");
                System.exit(0);
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.print("\nError: Too many inputs detected\n");
                System.out.print("Please restart the program and only enter 15 numbers\n");
                System.exit(0);
            }
            catch(Exception e) {
                System.out.print("\nError: Something went wrong\n");
                System.out.print("Please restart the program and try again\n");
                System.exit(0);
            }
        }

        if(stringNumbers.length < 15)
        {
            System.out.print("\nError: "+ stringNumbers.length +" inputs detected\n");
            System.out.print("Please restart the program and enter exactly 15 numbers\n");
            System.exit(0);
        }
     
        return numbers;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int[] nodeData = GetUserInput();

        for (int i = 0; i < nodeData.length; i++) {
            create(nodeData[i]);
        }
        System.out.print("\nResults:\n");
        inorderRec(node);
    }
}
