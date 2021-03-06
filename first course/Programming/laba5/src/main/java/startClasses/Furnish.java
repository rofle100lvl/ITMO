package startClasses;

import javax.xml.bind.annotation.*;

@XmlType(name = "Furnish")
@XmlEnum
public enum Furnish {
    DESIGNER,
    NONE,
    FINE,
    LITTLE;
}