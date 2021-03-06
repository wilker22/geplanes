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
package br.com.linkcom.sgm.controller.report;

import org.springframework.web.servlet.ModelAndView;

import br.com.linkcom.neo.authorization.report.ReportAuthorizationModule;
import br.com.linkcom.neo.bean.annotation.Bean;
import br.com.linkcom.neo.controller.Action;
import br.com.linkcom.neo.controller.Controller;
import br.com.linkcom.neo.controller.DefaultAction;
import br.com.linkcom.neo.controller.resource.ResourceGenerationException;
import br.com.linkcom.neo.core.web.WebRequestContext;
import br.com.linkcom.neo.report.IReport;
import br.com.linkcom.sgm.controller.report.filtro.AnomaliaSinteticoPorStatusReportFiltro;
import br.com.linkcom.sgm.service.AnomaliaService;
import br.com.linkcom.sgm.util.FiltroUtils;

/**
 * @author Rodrigo Alvarenga
 */
@Bean
@Controller(path="/sgm/report/AnomaliaSinteticoPorStatus", authorizationModule=ReportAuthorizationModule.class)
public class AnomaliaSinteticoPorStatusReport extends GeplanesReport<AnomaliaSinteticoPorStatusReportFiltro>{

	private AnomaliaService anomaliaService;
	
	public void setAnomaliaService(AnomaliaService anomaliaService) {
		this.anomaliaService = anomaliaService;
	}
	
	@Override
	@Action("gerar")
	public IReport createReportGeplanes(WebRequestContext request, AnomaliaSinteticoPorStatusReportFiltro filtro) throws Exception {
		return anomaliaService.createAnomaliaSinteticoPorStatusReport(filtro);
	}
	
	@Override
	@DefaultAction
	public ModelAndView doFiltro(WebRequestContext request,AnomaliaSinteticoPorStatusReportFiltro filtro)throws ResourceGenerationException {
		/*** Seta valores default para o filtro ***/		
		FiltroUtils.preencheFiltroPlanoGestaoUnidadeUsuario(filtro);	
		return super.doFiltro(request, filtro);
	}
	
	@Override
	public String getTitulo() {
		return "Relat�rio Sint�tico de Anomalias Por Status";
	}
	
}
