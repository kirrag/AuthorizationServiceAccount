package ru.netology.service;

import java.util.List;
//import java.util.Optional;
import org.springframework.stereotype.Service;

import ru.netology.repository.UserRepositoryStubImpl;
import ru.netology.authority.Authorities;
import ru.netology.exception.InvalidCredentials;
import ru.netology.exception.UnauthorizedUser;
import ru.netology.model.Account;
import ru.netology.exception.AccountNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt; 

@Service
public class AuthorizationService {

	UserRepositoryStubImpl userRepository;
	Account account;

	public AuthorizationService(UserRepositoryStubImpl userRepository) {
		this.userRepository = userRepository;
	}

	public List<Authorities> getAuthorities(Account account) {


		if (isEmpty(account.getUser())) {
			throw new InvalidCredentials("User name is empty");
		}

		if (isEmpty(account.getPassword())) {
			throw new InvalidCredentials("Password is empty");
		}

		Account a = userRepository.getAccountByName(account.getUser()).orElseThrow(AccountNotFoundException::new);

		List<Authorities> userAuthorities = userRepository.getUserAuthorities(a);

		//if (isEmpty(userAuthorities) || !a.getPassword().equals(account.getPassword())) {
		if (isEmpty(userAuthorities) || ! BCrypt.checkpw(account.getPassword(), a.getPassword())) {
			throw new UnauthorizedUser("Unauthorized user " + account.getUser());
		}

		return userAuthorities;
	}

	private boolean isEmpty(String str) {
		return str == null || str.isEmpty();
	}

	private boolean isEmpty(List<Authorities> str) {
		return str == null || str.isEmpty();
	}

	//private boolean isEmpty(Account account) {
	//	return account == null;
	//}
}
