// Targeted by JavaCPP version 1.5.6-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.depthai;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;
import org.bytedeco.opencv.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_core.*;
import org.bytedeco.opencv.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgproc.*;

import static org.bytedeco.depthai.global.depthai.*;


/**
 * Specify properties for StereoDepth
 */
@Namespace("dai") @Properties(inherit = org.bytedeco.depthai.presets.depthai.class)
public class StereoDepthProperties extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public StereoDepthProperties() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public StereoDepthProperties(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public StereoDepthProperties(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public StereoDepthProperties position(long position) {
        return (StereoDepthProperties)super.position(position);
    }
    @Override public StereoDepthProperties getPointer(long i) {
        return new StereoDepthProperties((Pointer)this).offsetAddress(i);
    }

    /**
     * Median filter config for disparity post-processing
     */
    public enum MedianFilter { MEDIAN_OFF(0), KERNEL_3x3(3), KERNEL_5x5(5), KERNEL_7x7(7);

        public final int value;
        private MedianFilter(int v) { this.value = v; }
        private MedianFilter(MedianFilter e) { this.value = e.value; }
        public MedianFilter intern() { for (MedianFilter e : values()) if (e.value == value) return e; return this; }
        @Override public String toString() { return intern().name(); }
    }

    /**
     * Align the disparity/depth to the perspective of a rectified output, or center it
     */
    public enum DepthAlign { RECTIFIED_RIGHT(0), RECTIFIED_LEFT(1), CENTER(2);

        public final int value;
        private DepthAlign(int v) { this.value = v; }
        private DepthAlign(DepthAlign e) { this.value = e.value; }
        public DepthAlign intern() { for (DepthAlign e : values()) if (e.value == value) return e; return this; }
        @Override public String toString() { return intern().name(); }
    }

    /**
     * Calibration data byte array
     */
    public native @Cast("std::uint8_t*") @StdVector BytePointer calibration(); public native StereoDepthProperties calibration(BytePointer setter);

    public native @ByRef EepromData calibrationData(); public native StereoDepthProperties calibrationData(EepromData setter);

    /**
     * Set kernel size for disparity/depth median filtering, or disable
     */
    public native MedianFilter median(); public native StereoDepthProperties median(MedianFilter setter);
    /**
     * Set the disparity/depth alignment to the perspective of a rectified output, or center it
     */
    public native DepthAlign depthAlign(); public native StereoDepthProperties depthAlign(DepthAlign setter);
    /**
     * Which camera to align disparity/depth to.
     * When configured (not AUTO), takes precedence over 'depthAlign'
     */
    public native CameraBoardSocket depthAlignCamera(); public native StereoDepthProperties depthAlignCamera(CameraBoardSocket setter);
    /**
     * Confidence threshold for disparity calculation, 0..255
     */
    public native @Cast("std::int32_t") int confidenceThreshold(); public native StereoDepthProperties confidenceThreshold(int setter);

    public native @Cast("bool") boolean enableRectification(); public native StereoDepthProperties enableRectification(boolean setter);
    /**
     * Computes and combines disparities in both L-R and R-L directions, and combine them.
     * For better occlusion handling
     */
    public native @Cast("bool") boolean enableLeftRightCheck(); public native StereoDepthProperties enableLeftRightCheck(boolean setter);
    /**
     * Computes disparity with sub-pixel interpolation (5 fractional bits), suitable for long range
     */
    public native @Cast("bool") boolean enableSubpixel(); public native StereoDepthProperties enableSubpixel(boolean setter);
    /**
     * Disparity range increased from 96 to 192, combined from full resolution and downscaled images.
     * Suitable for short range objects
     */
    public native @Cast("bool") boolean enableExtendedDisparity(); public native StereoDepthProperties enableExtendedDisparity(boolean setter);
    /**
     * Mirror rectified frames: true to have disparity/depth normal (non-mirrored)
     */
    public native @Cast("bool") boolean rectifyMirrorFrame(); public native StereoDepthProperties rectifyMirrorFrame(boolean setter);
    /**
     * Fill color for missing data at frame edges: grayscale 0..255, or -1 to replicate pixels
     */
    public native @Cast("std::int32_t") int rectifyEdgeFillColor(); public native StereoDepthProperties rectifyEdgeFillColor(int setter);
    /**
     * Input frame width. Optional (taken from MonoCamera nodes if they exist)
     */
    public native @ByRef @Cast("tl::optional<std::int32_t>*") IntOptional width(); public native StereoDepthProperties width(IntOptional setter);
    /**
     * Input frame height. Optional (taken from MonoCamera nodes if they exist)
     */
    public native @ByRef @Cast("tl::optional<std::int32_t>*") IntOptional height(); public native StereoDepthProperties height(IntOptional setter);

    // TODO: rectification mesh option for fisheye camera use-cases
}
