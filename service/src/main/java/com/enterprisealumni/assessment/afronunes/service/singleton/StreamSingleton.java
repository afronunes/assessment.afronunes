/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-13
 */
package com.enterprisealumni.assessment.afronunes.service.singleton;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides methods related to Streams.
 */
public class StreamSingleton {

    /**
     * Instance
     */
    private static StreamSingleton singleInstance = null;

    /**
     * Provides an instance of {@link StreamSingleton}
     *
     * @return
     */
    public static StreamSingleton getInstance() {
        if (singleInstance == null) {
            singleInstance = new StreamSingleton();
        }

        return singleInstance;
    }

    /**
     * Private constructor to this Singleton class.
     */
    private StreamSingleton() {
    }

    /**
     * Returns an inputStream generated by List<String>
     * @param pLines
     * @return
     */
    public InputStream getInputStream(final List<String> pLines) throws IOException {

        final ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            final byte[] lineSeparator = System.lineSeparator().getBytes();

            for (String line : pLines) {
                out.write(line.getBytes());
                out.write(lineSeparator);
            }
            return new ByteArrayInputStream(out.toByteArray());

        } catch (Exception ex) {
            throw ex;
        } finally {
            if (out != null) out.close();
        }
    }

    /**
     * Returns lines from pInputStream
     *
     * @param pInputStream
     * @return
     * @throws IOException
     */
    public List<String> readLinesFromInputStream(final InputStream pInputStream)
            throws IOException {

        final List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(pInputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line.concat("\n"));
            }
        }
        return lines;
    }
}
