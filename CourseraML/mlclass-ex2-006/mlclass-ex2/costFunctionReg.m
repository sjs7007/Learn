function [J, grad] = costFunctionReg(theta, X, y, lambda)
%COSTFUNCTIONREG Compute cost and gradient for logistic regression with regularization
%   J = COSTFUNCTIONREG(theta, X, y, lambda) computes the cost of using
%   theta as the parameter for regularized logistic regression and the
%   gradient of the cost w.r.t. to the parameters. 

% Initialize some useful values
m = length(y); % number of training examples

% You need to return the following variables correctly 
J = 0;
grad = zeros(size(theta));

% ====================== YOUR CODE HERE ======================
% Instructions: Compute the cost of a particular choice of theta.
%               You should set J to the cost.
%               Compute the partial derivatives and set grad to the partial
%               derivatives of the cost w.r.t. each parameter in theta


%calculate value of z to supply to sigmoid function
temp1 = theta' * X';

%get value of hypothesis by giving temp1 to sigmoid function
temp2 = sigmoid(temp1');

% temp3 = log(hx) , temp4 = log(1-hx)
temp3 = log(temp2);
temp4 = log(1-temp2);

% get left part, y log hx
temp5 = y' * temp3 % <-- left part

% get right part, (1-y) log(1-hx)
temp6 = 1 - y;
temp7 = temp6' * temp4; % <-- right part

% ans = (-1/m) * (left - right) 
temp8 = (-1/m) * (temp5 + temp7);

temp9=sum(sum(temp8))

temp10=lambda*(sum(sum(theta .* theta)))/(2*m) -lambda*(theta(1)*theta(1))/(2*m)

J = temp9+temp10

temp11 = (1/m) * (temp2-y)'*X + lambda * theta' / (m) 
temp11(1)=temp11(1)- lambda * theta(1) / (m)
grad = temp11

% =============================================================

end
