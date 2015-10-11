# 3D_Scan_Project
Android client-server App for 3D reconstruction.

The app allows to create a 3D model from 2D images taken with the mobile device.
It sends the image via an xml container to a server (which is included in the project).
The server internally makes call to the program "bundler"
http://www.cs.cornell.edu/~snavely/bundler/
which extracts and matches a desnse set of features used for reconstruction.

The resulting .ply file is postprocessed via Meshlab
http://meshlab.sourceforge.net/
and sent back to the mobile device where it can be displayd with KiwiViewer
http://www.kiwiviewer.org/

