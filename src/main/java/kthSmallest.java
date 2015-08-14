import java.util.ArrayList;
import java.util.List;

/**
 * Created by longweiquan on 15/8/14.
 */
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> list = new ArrayList<>();

        // transform Tree to List
        toList(list, root);
        return list.get(k-1).val;
    }

    public void toList(List<TreeNode> list, TreeNode node){
        if(node == null) {
            return;
        }
        toList(list, node.left);
        list.add(node);
        toList(list, node.right);
    }
}
