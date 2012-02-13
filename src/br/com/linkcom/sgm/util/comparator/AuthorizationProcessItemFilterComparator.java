/* 
		Copyright 2007,2008,2009,2010 da Linkcom Inform�tica Ltda
		
		Este arquivo � parte do programa GEPLANES.
 	   
 	    O GEPLANES � software livre; voc� pode redistribu�-lo e/ou 
		modific�-lo sob os termos da Licen�a P�blica Geral GNU, conforme
 	    publicada pela Free Software Foundation; tanto a vers�o 2 da 
		Licen�a como (a seu crit�rio) qualquer vers�o mais nova.
 	
 	    Este programa � distribu�do na expectativa de ser �til, mas SEM 
		QUALQUER GARANTIA; sem mesmo a garantia impl�cita de 
		COMERCIALIZA��O ou de ADEQUA��O A QUALQUER PROP�SITO EM PARTICULAR. 
		Consulte a Licen�a P�blica Geral GNU para obter mais detalhes.
 	 
 	    Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral GNU  	    
		junto com este programa; se n�o, escreva para a Free Software 
		Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 
		02111-1307, USA.
		
*/
package br.com.linkcom.sgm.util.comparator;

import java.util.Comparator;

import br.com.linkcom.neo.authorization.AuthorizationProcessItemFilter;
import br.com.linkcom.neo.util.StringUtils;

public class AuthorizationProcessItemFilterComparator implements Comparator<AuthorizationProcessItemFilter> {
	
	private StringUtils stringUtils;

	public AuthorizationProcessItemFilterComparator() {
		this.stringUtils = new StringUtils();
	}
	
	public StringUtils getStringUtils() {
		return stringUtils;
	}

	public void setStringUtils(StringUtils stringUtils) {
		this.stringUtils = stringUtils;
	}

	public int compare(AuthorizationProcessItemFilter o1, AuthorizationProcessItemFilter o2) {
		if (o1.getDescription() != null && o2.getDescription() != null) {
			return stringUtils.tiraAcento(o1.getDescription()).compareToIgnoreCase(stringUtils.tiraAcento(o2.getDescription()));
		}
		return 0;
	}

}