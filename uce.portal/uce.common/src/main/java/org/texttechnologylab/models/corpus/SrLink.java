package org.texttechnologylab.models.corpus;

import org.texttechnologylab.models.ModelBase;
import org.texttechnologylab.models.UIMAAnnotation;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="srLink")
public class SrLink extends ModelBase {
    private int figureBegin;
    private int figureEnd;
    private String figureCoveredText;
    private int groundBegin;
    private int groundEnd;
    private String groundCoveredText;
    private String relationType;

    public SrLink(){}

    public int getFigureBegin() {
        return figureBegin;
    }

    public void setFigureBegin(int figureBegin) {
        this.figureBegin = figureBegin;
    }

    public int getFigureEnd() {
        return figureEnd;
    }

    public void setFigureEnd(int figureEnd) {
        this.figureEnd = figureEnd;
    }

    public String getFigureCoveredText() {
        return figureCoveredText;
    }

    public void setFigureCoveredText(String figureCoveredText) {
        this.figureCoveredText = figureCoveredText;
    }

    public int getGroundBegin() {
        return groundBegin;
    }

    public void setGroundBegin(int groundBegin) {
        this.groundBegin = groundBegin;
    }

    public int getGroundEnd() {
        return groundEnd;
    }

    public void setGroundEnd(int groundEnd) {
        this.groundEnd = groundEnd;
    }

    public String getGroundCoveredText() {
        return groundCoveredText;
    }

    public void setGroundCoveredText(String groundCoveredText) {
        this.groundCoveredText = groundCoveredText;
    }

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }
}
