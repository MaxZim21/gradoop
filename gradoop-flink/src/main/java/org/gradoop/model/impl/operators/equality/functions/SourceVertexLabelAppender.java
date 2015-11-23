package org.gradoop.model.impl.operators.equality.functions;

import org.apache.flink.api.common.functions.JoinFunction;
import org.gradoop.model.impl.operators.equality.tuples.EdgeDataLabel;
import org.gradoop.model.impl.operators.equality.tuples.DataLabel;

/**
 * Created by peet on 23.11.15.
 */
public class SourceVertexLabelAppender
  extends VertexLabelAppender
  implements JoinFunction<EdgeDataLabel, DataLabel, DataLabel> {

  @Override
  public DataLabel join(
    EdgeDataLabel edgeLabel, DataLabel sourceVertexLabel
  ) throws Exception {

    return new DataLabel(
      edgeLabel.getTargetVertexId(), label(edgeLabel, sourceVertexLabel)
    );
  }
}
