export class Constants {
  //password must be minimum 8 characters long including at least one uppercase letter, one lowercase letter and one number
  public static PASSWORD_PATTERN = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
  public static EMAIL_PATTERN = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
  //username must be minimum 3 characters long and valid characters are: a-z, A-Z, 0-9
  public static USERNAME_PATTERN = "^[a-zA-Z0-9]{3,}$";
  public static FIRSTNAME_LASTNAME_PATTERN = "^([A-z][A-Za-z]*\\s+[A-Za-z]*)|([A-z][A-Za-z]*)$";
}
