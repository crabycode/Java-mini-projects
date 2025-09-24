public class User implements validator{
    String nickName;
    String password;
    public User(String stefan, String number) {
        this.nickName = nickName;
        this.password = password;
    }
    public boolean check(String nickName) throws checkFailed{
        for(int i = 0; i<nickName.length(); i++){
            if(nickName.charAt(i)=='@'){
                throw new checkFailed("You have entered email instead of nickname");
            }
        }
        return true;
    }
}
