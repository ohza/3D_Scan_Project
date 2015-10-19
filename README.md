# 3D_Scan_Project
Android client-server application for 3D reconstruction.

The app allows to create a 3D model from 2D images taken with the mobile device.
It sends the image via an xml container to a server (which is included in the project).
The server internally makes call to the program "bundler"
http://www.cs.cornell.edu/~snavely/bundler/
which extracts and matches a desnse set of features used for reconstruction.

The resulting .ply file is postprocessed via Meshlab
http://meshlab.sourceforge.net/
and sent back to the mobile device where it can be displayd with KiwiViewer
http://www.kiwiviewer.org/

The path to bundler, meshlab have to be adjusted and the ip / port of the server modifed.
(I will try to make this more automated in the future)

The 3D_Scan_Server has dependencies on the following jar files:
* commons-codec-1.9.jar
* commons-io-2.4.jar
* netty-3.9.0.Final.jar

(Which are now included in the project as Referenced libraries)
