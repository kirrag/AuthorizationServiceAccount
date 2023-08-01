package ru.netology.handler;
	
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import ru.netology.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Collections;
import ru.netology.authority.Authorities;

 
public final class AccountHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
 
	@Autowired
	Account account;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(Account.class);
    }
 
    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {
		//long  userId = (long) Integer.parseInt(nativeWebRequest.getParameter("userid"));
        String user = nativeWebRequest.getParameter("user");
        String password = nativeWebRequest.getParameter("password");
	//	List<Authorities> authorities  = Collections.emptyList();

		//if(isNotSetUserId(userId)) {
		//	userId = 1000;
		//}
 
        if (isNotSet(user)) {
            user = "defaultUser";
        }
 
        if (isNotSet(password)) {
            password = "defaultPassword";
        }

		//if (isNotSetAuth(authorities)) {
		//	authorities  = Collections.emptyList();
		//}
 
        //return new Account(userId, user, password, authorities);
        return new Account(user, password);
    }



	//private boolean isNotSetUserId(long value) {
	//	return value == 0;
	//}

	//private boolean isNotSetAuth(List<Authorities> value) {
	//	return value == null;
	//}
 
    private boolean isNotSet(String value) {
        return value == null;
    }
}
	
