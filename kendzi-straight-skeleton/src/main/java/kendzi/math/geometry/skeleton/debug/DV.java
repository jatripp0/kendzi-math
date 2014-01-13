package kendzi.math.geometry.skeleton.debug;

import java.awt.Color;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import javax.vecmath.Point2d;

import kendzi.math.geometry.debug.DebugDisplay;
import kendzi.math.geometry.debug.DebugLayer;
import kendzi.math.geometry.debug.DisplayLineParametric2d;
import kendzi.math.geometry.debug.DisplayLineSegment2d;
import kendzi.math.geometry.debug.DisplayObject;
import kendzi.math.geometry.debug.DisplayPoints;
import kendzi.math.geometry.debug.DisplayPolygon;
import kendzi.math.geometry.debug.DisplayPolygonNames;
import kendzi.math.geometry.line.LineParametric2d;
import kendzi.math.geometry.line.LineSegment2d;
import kendzi.math.geometry.skeleton.Skeleton.EdgeEntry;
import kendzi.math.geometry.skeleton.Skeleton.FaceNode;
import kendzi.math.geometry.skeleton.Skeleton.FaceQueue;
import kendzi.math.geometry.skeleton.Skeleton.SkeletonOutput;
import kendzi.math.geometry.skeleton.Skeleton.VertexEntry2;
import kendzi.math.geometry.skeleton.circular.CircularList;
import kendzi.math.geometry.skeleton.debug.display.DisplayEventNames;
import kendzi.math.geometry.skeleton.debug.display.DisplayEventQueue;
import kendzi.math.geometry.skeleton.debug.display.DisplayFaceNode;
import kendzi.math.geometry.skeleton.debug.display.DisplayIntersectEntry;
import kendzi.math.geometry.skeleton.debug.display.DisplayLav2;
import kendzi.math.geometry.skeleton.debug.display.DisplaySkeletonOut;
import kendzi.math.geometry.skeleton.events.SkeletonEvent;

public class DV {

    private static boolean debug;

    private static DebugLayer dv = null;

    public static void enableDebug() {
        if (dv == null) {
            dv = DebugDisplay.getDebugDisplay().getDebugLayer();
        }
        debug = true;
    }

    public static void debug(FaceNode fn) {
        if (debug) {
            if (fn != null) {
                dv.addDebug(new DisplayFaceNode(fn, Color.red));
            }
        }
    }

    public static void debug(FaceQueue f) {
        if (debug) {
            dv.addDebug(new DisplayFaceNode(f, Color.pink.darker()));
        }
    }

    public static void debug(SkeletonEvent I) {
        if (debug) {
            dv.addDebug(new DisplayIntersectEntry(I, Color.red));
        }
    }

    public static void debug(PriorityQueue<SkeletonEvent> queue) {
        if (debug) {
            dv.addDebug(new DisplayEventQueue(queue));
        }
    }

    public static void debug(Set<CircularList<VertexEntry2>> set) {
        if (debug) {
            for (CircularList<VertexEntry2> circularList : set) {
                if (circularList.size() > 0) {
                    debug(circularList);
                }
            }
        }
    }

    public static void debug(CircularList<VertexEntry2> l) {
        if (debug) {
            dv.addDebug(new DisplayLav2(l, Color.ORANGE.darker().darker()));
        }
    }

    public static void debug(SkeletonOutput pOutput) {
        if (debug) {
            dv.addDebug(new DisplaySkeletonOut(pOutput));
        }
    }

    public static void debug(LineSegment2d pLineSegment2d) {
        if (debug) {
            dv.addDebug(new DisplayLineSegment2d(pLineSegment2d.getBegin(), pLineSegment2d.getEnd(), Color.GRAY));
        }
    }

    public static void debug(Point2d pPoint2d) {
        if (debug) {
            dv.addDebug(new DisplayPoints(pPoint2d));
        }
    }

    public static void debug(LineParametric2d pLineParametric2d) {
        if (debug) {
            dv.addDebug(new DisplayLineParametric2d(pLineParametric2d));
        }
    }

    public static void debug(List<Point2d> polygon) {
        if (debug) {
            dv.addDebug(new DisplayPolygon(polygon));
        }
    }

    public static void debugNames(List<Point2d> polygon) {
        if (debug) {
            dv.addDebug(new DisplayPolygonNames(polygon));
        }
    }

    public static void debug(DisplayObject displayObject) {
        if (debug) {
            dv.addDebug(displayObject);
        }
    }

    public static void debugProcessedEvents(List<SkeletonEvent> processedEvents) {
        if (debug) {
            dv.addDebug(new DisplayEventNames(processedEvents));
        }
    }

    public static void clear() {
        if (debug) {
            dv.clear();
        }
    }

    public static void block() {
        if (debug) {
            DebugDisplay.getDebugDisplay().block();
        }
    }

    public static void debug(EdgeEntry edge) {
        if (debug) {
            dv.addDebug(new DisplayLineSegment2d(edge.p1, edge.p2, Color.GRAY.darker()));
        }
    }
}
