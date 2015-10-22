# 3D_Scan_Project
Android client-server application for 3D reconstruction.

The app allows to create a 3D model from 2D images taken with and Android device.
It sends the image via an xml container to a server (which is included in the project).
The server internally makes call to a SFM program named Bundler, which can be obtained from:
http://www.cs.cornell.edu/~snavely/bundler/
Bundler extracts and matches a dense set of features used for reconstruction.

The resulting .ply file is postprocessed via Meshlab
http://meshlab.sourceforge.net/
and sent back to the mobile device where it can be displayd with KiwiViewer
http://www.kiwiviewer.org/

The path to Bundler, Meshlab need to be adjusted and the ip / port of the server modifed.
(I will try to make this more automated in the future)

The 3D_Scan_Server has dependencies on the following jar files:
* commons-codec-1.9.jar
* commons-io-2.4.jar
* netty-3.9.0.Final.jar

(Which are now included in the project as Referenced libraries)

![alt text](https://github.com/ohza/3D_Scan_Project/blob/master/example.png "Example")
