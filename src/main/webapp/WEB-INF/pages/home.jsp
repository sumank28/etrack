<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <style>
            .error {
                color: #ff0000;
            }

            .errorblock {
                color: #000;
                background-color: #ffEEEE;
                border: 3px solid #ff0000;
                padding: 8px;
                margin: 16px;
            }
        </style>
    </head>
    <body>
        <h1>${message}</h1>

        <a href="">Login</a>
        <a href="">List Users</a>
        <a href="">List Devices</a>

        <form:form method="post" action="checkout" modelAttribute="tracker">
            <form:errors path="*" cssClass="errorblock" element="div"/>

            <form:select path="itemId">
                <form:option value="NONE" label="--- Select ---"/>
                <form:options items="${itemList}" itemLabel="itemName" itemValue="itemId" />
            </form:select>

            <form:select path="username">
                <form:option value="NONE" label="--- Select ---"/>
                <form:options items="${userList}" itemLabel="name" itemValue="username" />
            </form:select>

            <input type="submit" name="submit" value="Checkout">
        </form:form>

    </body>
</html>