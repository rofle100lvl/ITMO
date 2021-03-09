package startClasses;

import javax.xml.bind.annotation.*;

/**
 * Начальный enum ремонта
 */
@XmlType(name = "Furnish")
@XmlEnum
public enum Furnish {
    DESIGNER,
    NONE,
    FINE,
    LITTLE;
}