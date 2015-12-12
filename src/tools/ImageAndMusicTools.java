package tools;

import java.io.File;

import audiovisual.AudioVisual;
import audiovisual.SimpleAudioVisual;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 11/8/13
 * Time: 4:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class ImageAndMusicTools {
	private AudioVisual<?, ?> lightSoundMapper;
	
	public ImageAndMusicTools() {
		lightSoundMapper = new SimpleAudioVisual();
	}
	
	public ImageAndMusicTools(AudioVisual<?, ?> map) {
		this.lightSoundMapper = map;
	}
	
    /**
     * Given an integer representation of color in the BufferedImage.TYPE_INT_ARGB
     * color model, returns an integer array with the values of alpha, R, G, and B.
     * @param color
     * @return
     */
    public static int[] getARGB(int color) {
        int[] argb_exploded = new int[4];

        argb_exploded[0] = (color >> 24) & 0x000000FF;
        argb_exploded[1] = (color >> 16) & 0x000000FF;
        argb_exploded[2] = (color >>8 ) & 0x000000FF;
        argb_exploded[3] = color & 0x000000FF;

        return argb_exploded;
    }

    /**
     * Returns a simple color-to-pitch function, where 21 is the lowest note
     * on a piano in the MIDI standard, and intensity is the 0-255 value
     * corresponding to R, G, or B. With 85 different pitches as possible output,
     * this function spans much of the 88-note range of the piano.
     * @param intensity
     * @return
     */
    public static int colorToPitch(int intensity) {
        return 21 + intensity/3;
    }

    /**
     * Approximately the inverse of the function used in colorToPitch().
     * @return
     */
    public static int pitchToColor(int note) {
        return (note-21)*3;
    }
    
    /**
     * Returns true if the filename belongs to a Midi file (i.e., with extension ".mid").
     * @param filename
     * @return
     */
    public static boolean isValidMidiFilename(String filename) {
        return filename.length()>4 && filename.substring(filename.length()-4).equalsIgnoreCase(".mid");
    }

    /**
     * Returns true if the filename belongs to a PNG file (i.e., with extension ".png").
     * @param filename
     * @return
     */
	public static boolean isValidPNGFilename(String filename) {
		return filename.length()>4 && filename.substring(filename.length()-4).equalsIgnoreCase(".png");
	}
	
	public static boolean isValidPNGFile(File file) {
		return file.exists() && isValidPNGFilename(file.getName());
	}

	public static boolean isValidMidiFile(File file) {
		return file.exists() && isValidMidiFilename(file.getName());
	}
}