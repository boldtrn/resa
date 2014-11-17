package task3;

/**
 * ***************************************************************************************************************
 * File:MiddleFilter.java Course: 17655 Project: Assignment 1 Copyright:
 * Copyright (c) 2003 Carnegie Mellon University Versions: 1.0 November 2008 -
 * Sample Pipe and Filter code (ajl).
 * <p/>
 * Description:
 * <p/>
 * This class serves as an example for how to use the FilterRemplate to create a
 * standard filter. This particular example is a simple "pass-through" filter
 * that reads data from the filter's input port and writes data out the filter's
 * output port.
 * <p/>
 * Parameters: None
 * <p/>
 * Internal Methods: None
 * <p/>
 * ****************************************************************************************************************
 */

public class DeleteFilter extends MeasurementFilterFramework {
    private final int id;

    /**
     * Instantiates a new DeleteFilter object which deletes the part of a frame which contains the measurement with <code>id</code>.
     *
     * @param id to remove
     */
    public DeleteFilter(int id) {
        super(1, 1);
        this.id = id;
    }

    public void run() {

        while (true) {
            try {
                Measurement measurement = readMeasurementFromInput();
                //System.out.println("DeleteFilter " + id + " " + measurement);
                if (measurement.getId() != this.id) {
                    writeMeasurementToOutput(measurement);
                }
            } catch (EndOfStreamException e) {
                ClosePorts();
                System.out.print("\n" + this.getName() + "::Delete Exiting;");
                break;
            }
        }

    } // run

} // MiddleFilter