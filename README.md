# 3D_Scan_Project
Android client-server application for 3D reconstruction.

The app allows to create a 3D model from 2D images taken with and Android device.
It sends the image via an xml container to a server (which is included in the project).
The server internally makes call to a SFM program named Bundler, which can be obtained from:
http://www.cs.cornell.edu/~snavely/bundler/

Bundler extracts and matches a dense set of features used for reconstruction.

The path to Bundler needs to be adjusted in the local server installation.
And the ip / port of the server have to be adjusted in the client.
3D_Scan_Project\3D_Scan\src\com\example\threedscan_demo\ClientThreadService.java
(I will try to make this more automated in the future)

The 3D_Scan_Server has dependencies on the following jar files:
* commons-codec-1.9.jar
* commons-io-2.4.jar
* netty-3.9.0.Final.jar

(Which are now included in the project as Referenced libraries)

![alt text](https://github.com/ohza/3D_Scan_Project/blob/master/example.jpg "Example")
