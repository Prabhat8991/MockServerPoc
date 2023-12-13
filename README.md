# Steps to run local mock server

1. Install mountebank: `npm install -g mountebank`
2. Execute `mb --configfile imposters.ejs` from project directory  - This will start mountebank server on local port with given configurations.
3. Change the baseurl of Retrofit client to point to local server
  
