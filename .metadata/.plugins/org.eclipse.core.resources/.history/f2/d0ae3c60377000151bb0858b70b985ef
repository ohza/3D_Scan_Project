

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;


public class ThreeD_ServerHandler extends SimpleChannelHandler {
	
	
	StringBuilder sbu;
	StringBuilder SBU = new StringBuilder();
	Thread PythonStuff_1;
	Thread PythonStuff_2;
	Thread PythonStuff_3;
	int i = 10;
	int i2 = 10;
	int i3 = 10;
	
	public static byte[] decodeImage(String imageDataString) {
        return Base64.decodeBase64(imageDataString);
    }
	
	public String getWithinTags(String matchString,String tag){

		final Pattern pattern = Pattern.compile("<"+tag+">(.+?)</"+tag+">");
		final Matcher matcher = pattern.matcher(matchString);
		try{
		matcher.find();
		return matcher.group(1);
		}
		catch(Exception e){
			System.out.println("An exception has occured within tags: "+e.toString());
			return "";
			
		}
	}
	
	
	static void removeBlankSpace(StringBuilder sb) {
		
		  int j = 0;
		  for(int i = 0; i < sb.length(); i++) {
		    if (!Character.isWhitespace(sb.charAt(i))) {
		       sb.setCharAt(j++, sb.charAt(i));
		    }
		  }
		  sb.delete(j, sb.length());
		}
	
	
	
	

	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
		sbu = new StringBuilder();
	    ChannelBuffer buf = (ChannelBuffer) e.getMessage();
	    while(buf.readable()) {
	    	sbu.append((char) buf.readByte());
	        //System.out.println((char) buf.readByte());
	    }
	    
	    SBU.append(sbu);
	    
	    if(SBU.toString().startsWith("<3DDemo>") &&  sbu.toString().endsWith("</3DDemo>")){
	    	
	    	
	    	
	    	 try {
					FileUtils.cleanDirectory(new File("c:\\Users\\o-a_000\\osm-bundler\\osm-bundlerWin64\\osm-bundler-myoutput"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	 
	    	
	            
	            try {
					FileUtils.cleanDirectory(new File("c:\\Users\\o-a_000\\osm-bundler\\osm-bundlerWin64\\examples\\BilderVonClient"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	
	    	System.out.println("A 3DDemo has been received");
	    	
	    	
	    	ThreeD_ServerHandler.removeBlankSpace(SBU);
	    	
	    	Integer.parseInt(getWithinTags(SBU.toString(),"ImAnzahl"));
	    	
	    	this.extractImage(Integer.parseInt(getWithinTags(SBU.toString(),"ImAnzahl")));
	        
	        /////////////////////////////
	    	
	    	
	    	PythonStuff_1 = new Thread() {
	    	    public void run() {
	    	        try {
	    	        	
	    	        	String command = "cmd.exe /c cd c:\\Users\\o-a_000\\osm-bundler\\osm-bundlerWin64 && c:\\Python27\\python.exe RunBundler.py --photos=\"./examples/BilderVonClient\" 2>&1";
	    		    	Process p=null;
	    		    
	    		    	
	    				try {
	    					p = Runtime.getRuntime().exec(command);
	    					OutputStream out1 = p.getOutputStream();
	    					InputStream err1 = p.getErrorStream();
	    					
	    					BufferedReader in = new BufferedReader(new 

	    							InputStreamReader(p.getInputStream()));
	    							String line;
	    							while ((line = in.readLine()) != null) {
	    							    System.out.println(line);
	    							}
	    					
	    				    } catch (IOException e1) {
	    					e1.printStackTrace();
	    					System.out.println("Errer with python");
	    				}
	    		    	
	    				try {
	    					i = p.waitFor();
	    				} catch (InterruptedException e1) {
	    					// TODO Auto-generated catch block
	    					e1.printStackTrace();
	    				}
	    		    	System.out.println("Wait for: "+i);
	    		    	
	    	        }
	    	        
	    	        catch(Exception v) {
	    	            System.out.println("Exception in thread: "+v.toString());
	    	        }
	    	    }  
	    	};

	    	PythonStuff_1.start();
	    	
	    	try {
				PythonStuff_1.join();
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				System.out.println("Thread interrupt exection: "+e2.toString());
				e2.printStackTrace();
			}
	    	
	    	
	    	PythonStuff_2 = new Thread() {
	    	    public void run() {
	    	        try {

	    	
	    		    	
	    		    	String command2 = "cmd.exe /c cd c:\\Users\\o-a_000\\osm-bundler\\osm-bundlerWin64 && c:\\Python27\\python.exe RunPMVS.py --bundlerOutputPath=\"c:/Users/o-a_000/osm-bundler/osm-bundlerWin64/osm-bundler-myoutput\" 2>&1";
	    		    	Process p2=null;
	    		    
	    		    	
	    				try {
	    					p2 = Runtime.getRuntime().exec(command2);
	    					OutputStream out2 = p2.getOutputStream();
	    					InputStream err2 = p2.getErrorStream();
	    					
	    					BufferedReader in = new BufferedReader(new 

	    							InputStreamReader(p2.getInputStream()));
	    							String line;
	    							while ((line = in.readLine()) != null) {
	    							    System.out.println(line);
	    							}

	    					
	    					
	    				} catch (IOException e1) {
	    					e1.printStackTrace();
	    				
	    				}
	    		    	
	    				try {
	    					i2 = p2.waitFor();
	    				} catch (InterruptedException e1) {
	    					// TODO Auto-generated catch block
	    					e1.printStackTrace();
	    				}
	    		    	System.out.println("Wait for: "+i2);

	    	            
	    	        	
	    	        } catch(Exception v) {
	    	            System.out.println("Exception in thread: "+v.toString());
	    	        }
	    	    }  
	    	};

	    	PythonStuff_2.start();
	    	
	    	try {
				PythonStuff_2.join();
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				System.out.println("Thread interrupt exection: "+e2.toString());
				e2.printStackTrace();
			}
	    	
	    	
	    	//////////////////////////////////////
	    	Thread PythonStuff_3;
			
			
			PythonStuff_3 = new Thread() {
	    	    public void run() {
	    	        try {
	    	        	String command3 = "cmd.exe /c cd c:\\Program Files\\VCG\\MeshLab && meshlabserver.exe -i c:\\Users\\o-a_000\\osm-bundler\\osm-bundlerWin64\\osm-bundler-myoutput\\pmvs\\models\\pmvs_options.txt.ply -o c:\\Users\\o-a_000\\osm-bundler\\osm-bundlerWin64\\osm-bundler-myoutput\\pmvs\\models\\pmvs_options_bin.ply -om vc, vn 2>&1" ;
	    		    	Process p3=null;
	    				try {
	    					p3 = Runtime.getRuntime().exec(command3);
	    					OutputStream out3 = p3.getOutputStream();
	    					InputStream err3 = p3.getErrorStream();
	    					
	    					BufferedReader in = new BufferedReader(new 

	    							InputStreamReader(p3.getInputStream()));
	    							String line;
	    							while ((line = in.readLine()) != null) {
	    							    System.out.println(line);
	    							}
	    					
	    				    } catch (IOException e1) {
	    					e1.printStackTrace();
	    					System.out.println("Errer with python 1");
	    				}
	    		    	
	    				try {
	    				
	    					i3 = p3.waitFor();
	    				} catch (InterruptedException e1) {
	    					// TODO Auto-generated catch block
	    					System.out.println("Errer with python 2:" +e1.toString());
	    					e1.printStackTrace();
	    				}
	    		    	System.out.println("Wait for: "+i3);
	    		    	
	    	        }
	    	        
	    	        catch(Exception v) {
	    	            System.out.println("Exception in thread: "+v.toString());
	    	        }
	    	    }  
	    	};

	    	PythonStuff_3.start();
	    	
	    	try {
				PythonStuff_3.join();
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				System.out.println("Thread interrupt exection: "+e2.toString());
				e2.printStackTrace();
			}
	    	

            String retString = null;
                        
            if((i==0 && i2==0) && i3==0){
	    	
	    	try {
	    		String fileString = this.encodeFileToBase64Binary("c:\\Users\\o-a_000\\osm-bundler\\osm-bundlerWin64\\osm-bundler-myoutput\\pmvs\\models\\pmvs_options_bin.ply");
	    	
				//fileString = fileString.replace("\n", "").replace("\r", "");
				retString = "<3DDemo><PLY_Status>OK</PLY_Status><PLY_File>"+fileString+"</PLY_File></3DDemo>";
				System.out.println("This bid is OK");
				
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				retString = "<3DDemo><PLY_Status>FAILED</PLY_Status><PLY_File></PLY_File></3DDemo>";
				System.out.println(e1.toString());
			}
	    	
            }
            
            else{
            	
            	retString = "<3DDemo><PLY_Status>FAILED</PLY_Status><PLY_File></PLY_File></3DDemo>";
            	
            }
	    	
	    	//System.out.println(retString);
	    	byte[] retbytes = retString.getBytes();
	    	
	    	e.getChannel().write(ChannelBuffers.wrappedBuffer(retbytes));
	    	
	    	System.out.println("I am at the very end");
	    	
	    }
	}
	
	
	String readFile(String fileName) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {
    	System.out.println("Exception...");
        e.getCause().printStackTrace();
        Channel ch = e.getChannel();
        ch.close();
        new ThreeD_Server();
    }
    
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
    	
    	
    	byte[] bytes = "<3DDemoSendOK/>".getBytes();
    	
    	e.getChannel().write(ChannelBuffers.wrappedBuffer(bytes));
    	System.out.println("Client Connected :"+ctx.getChannel().getRemoteAddress().toString());
    	
    }
    
    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e){
    	System.out.println("Client Disconnected :"+ctx.getChannel().getRemoteAddress().toString());
    	
    }
    
    
    public void extractImage(int Anzahl){
    	
    	for(int a=0;a<Anzahl;a++){
    	byte[] imageByteArray = decodeImage(getWithinTags(SBU.toString(),"ImBin_"+a));
    	FileOutputStream imageOutFile=null;
        
        // Write a image byte array into file system
        try {
			imageOutFile = new FileOutputStream("/Users/o-a_000/osm-bundler/osm-bundlerWin64/examples/BilderVonClient/Bild_"+a+".jpg");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			imageOutFile.write(imageByteArray);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

   
        try {
			imageOutFile.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	}
        
        //////////////////////////////////////
    }
    
    
    private String encodeFileToBase64Binary(String fileName)
			throws IOException {
    	
    	System.out.println(fileName);
 
		File file = new File(fileName);
		byte[] bytes = loadFile(file);
		byte[] encoded = Base64.encodeBase64(bytes);
		String encodedString = new String(encoded);
 
		return encodedString;
	}
 
	private static byte[] loadFile(File file) throws IOException {
	    InputStream is = new FileInputStream(file);
 
	    long length = file.length();
	    if (length > Integer.MAX_VALUE) {
	        // File is too large
	    }
	    byte[] bytes = new byte[(int)length];
	    
	    int offset = 0;
	    int numRead = 0;
	    while (offset < bytes.length
	           && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	        offset += numRead;
	    }
 
	    if (offset < bytes.length) {
	        throw new IOException("Could not completely read file "+file.getName());
	    }
 
	    is.close();
	    return bytes;
	}
    
 	
}