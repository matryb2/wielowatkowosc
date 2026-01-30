public class UserModel {

    public boolean walidujLogowanie(String user, String pass) {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return user.equals("admin") && pass.equals("haslo123");
    }
}
