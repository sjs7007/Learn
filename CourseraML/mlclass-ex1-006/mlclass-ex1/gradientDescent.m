function [theta, J_history] = gradientDescent(X, y, theta, alpha, num_iters)
%GRADIENTDESCENT Performs gradient descent to learn theta
%   theta = GRADIENTDESENT(X, y, theta, alpha, num_iters) updates theta by 
%   taking num_iters gradient steps with learning rate alpha

% Initialize some useful values
m = length(y); % number of training examples
J_history = zeros(num_iters, 1);

for iter = 1:num_iters

    % ====================== YOUR CODE HERE ======================
    % Instructions: Perform a single gradient step on the parameter vector
    %               theta. 
    %
    % Hint: While debugging, it can be useful to print out the values
    %       of the cost function (computeCost) and gradient here.
    %

    % theta is column vector(2*1), first convert it to row vector as theta'(1*2)
    % then X is a 97 * 2 matrix consisting of 97 training example values for x0, always =1 and x1
    % take X' to get (2*97) matrix
    % to get htheta(x)=multiply theta' and X' to get 1*97 matrix
    temp1 = theta' * X'; 

    %convert row vector temp1 to column vector 97*1
    temp1=temp1';

    %do temp1 - temp2
    temp2 = temp1 - y;

    %temp2 = 97*1
    %temp2' *X = 1*97  * 97*2

    theta = theta - alpha *(1/m) *(temp2' * X)';
    

    % ============================================================

    % Save the cost J in every iteration    
    J_history(iter) = computeCost(X, y, theta);

end

end
