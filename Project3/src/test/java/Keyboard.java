public class Keyboard {

    //tryHideKeyboard hides the keyboard from the screen
    public static void tryHideKeyboard(){
        try{
            DriverInitiation.driver.hideKeyboard();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
