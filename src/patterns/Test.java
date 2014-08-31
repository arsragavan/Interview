/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package patterns;
interface Test2 {
    // default public and abstract
    void ifmethod1();
    void ifmethod2();
}
abstract class Test1 {
    int a;
    public abstract void abmethod1();
    public void abmethod2() {
        abmethod1();
    }
}
public class Test extends Test1 implements Test2{

    @Override
    public void abmethod1() {
        
    }
    @Override
    public void ifmethod2() {
        
    }
    
    public static void main(String args[]) {
        
    }

    @Override
    public void ifmethod1() {
        
        
    }
}
