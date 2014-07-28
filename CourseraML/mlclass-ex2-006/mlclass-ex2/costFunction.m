function [J, grad] = costFunction(theta, X, y)
%COSTFUNCTION Compute cost and gradient for logistic regression
%   J = COSTFUNCTION(theta, X, y) computes the cost of using theta as the
%   parameter for logistic regression and the gradient of the cost
%   w.r.t. to the parameters.

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
%
% Note: grad should have the same dimensions as theta
%

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
J=sum(sum(temp8))

temp9 = (1/m) * (temp2-y)'*X
grad = temp9

% =============================================================

end
