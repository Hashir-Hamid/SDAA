/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

/**
 *
 * @author Hashir Hamid
 */
public class LoginService {
    private UserDAO userDAO = new UserDAO();

    public boolean login(String username, String password) {
        return userDAO.validateUser(username, password);
    }
}
