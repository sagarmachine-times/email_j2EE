# email_j2EE
java training exercise


Listeners :

ApplicationContextListener - is a ServletContextListener, whose function will run at the time of deployment before any request.
DB connection object is created and saved to ServletContext, which can be shared all over the application


Filters :AuthenticateFilter - it interprets all the secured urls (or Servlets) request, validate if user is authenticated or not.
 "/welcome", "/inbox", "/compose", "/draft", "/sent", "/logout"

Servlets :
1. HelloServlet -> /hello
2. RegisterServlet -> /register
3. LoginServlet -> /login
4. ComposeServlet -> /compose
5. DraftServlet -> /draft
6. InboxServlet -> /inbox
7. SentServlet -> /sent
8. WelcomeServlet -> /welcome
9. LogoutServlet -> /logout
10.AboutServlet -> /about
