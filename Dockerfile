# define the base image
FROM nginx:latest

#set the working directory
WORKDIR /usr/share/nginx/html

#copy the files from the current directory to the working directory
COPY . /usr/share/nginx/html

# expose the port
EXPOSE 81

# run the command
CMD ["nginx", "-g", "daemon off;"]