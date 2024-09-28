#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main() {
    string s = "ab-de+f*/";  // Postfix expression
    stack<string> st;

    for (int i = s.length() - 1; i >= 0; i--) {
        if (isalnum(s[i])) {
            // Push the operand (characters) onto the stack
            st.push(s[i]);
        } else {
            // Pop the top two operands from the stack
            string s1 = st.top();
            st.pop();
            string s2 = st.top();
            st.pop();
            // Create a new infix expression and push it back onto the stack
            st.push("(" + s1 + s[i] + s2 + ")");
        }
    }

    // Print the final infix expression
    if (!st.empty()) {
        cout << st.top() << endl;
    }else{
        cout<<'s';
    }
    return 0;
}
