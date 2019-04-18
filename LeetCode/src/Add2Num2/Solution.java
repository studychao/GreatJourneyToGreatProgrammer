package Add2Num2;

import java.util.List;

class Solution {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
          int num1 = 0;
          int num2 = 0;
          int result = 0;
          int curry = 0 ;
          ListNode start = new ListNode(0);


          while ( l1 != null || l2!=null){
              if (l1 == null) {
                  num1 = 0;
              }
              else{
                  num1 = l1.val;
              }
              if (l2 == null) {
                  num2 = 0;
              }
              else{
                  num2 = l2.val;
              }
              result = num1 + num2;
              if (curry == 1)
              {
                  result = result + 1;
                  curry = 0;
              }
              if (result >= 10){
                  result= result - 10;
                  curry = 1;
              }
              start.next = new ListNode(result);

          }

          return start.next;
    }
}